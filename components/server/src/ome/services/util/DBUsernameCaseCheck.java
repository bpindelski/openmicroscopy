/*
 * Copyright (C) 2014 University of Dundee & Open Microscopy Environment.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package ome.services.util;

import ome.conditions.InternalException;
import ome.system.PreferenceContext;
import ome.util.SqlAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hook run by the context to conditionally lowercase all entries in the
 * <code>omename</code> column of the <code>Experimenter</code> table. Only
 * executed if <code>omero.security.ignore_case</code> is <code>true</code>.
 * 
 * @author Blazej Pindelski, bpindelski at dundee.ac.uk
 * @since 5.1
 */
public class DBUsernameCaseCheck extends BaseDBCheck {

    public final static Logger log = LoggerFactory
            .getLogger(DBUsernameCaseCheck.class);

    private boolean performCaseChange;

    private int updatedRows;

    public DBUsernameCaseCheck(Executor executor, PreferenceContext preferences) {
        super(executor, preferences);
        performCaseChange = Boolean.parseBoolean(preferences
                .getProperty("omero.security.ingore_case"));
    }

    @Override
    protected void doCheck() {
        if (performCaseChange) {
            try {
                updatedRows = (Integer) executor
                        .executeSql(new Executor.SimpleSqlWork(this,
                                "DBUsernameCaseCheck") {
                            @Transactional(readOnly = false)
                            public Object doWork(SqlAction sql) {
                                return sql.lowercaseUserNames();
                            }
                        });
            } catch (Exception e) {
                final String msg = "Error lowercasing user names.";
                log.error(msg, e); // slf4j migration: fatal() to error()
                InternalException ie = new InternalException(msg);
                throw ie;
            }
        }
    }

    @Override
    public String getCheckDone() {
        return "user names lowercased: " + updatedRows;
    }

}
