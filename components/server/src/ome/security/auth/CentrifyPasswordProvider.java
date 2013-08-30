/*
 * Copyright (C) 2013 University of Dundee & Open Microscopy Environment.
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

package ome.security.auth;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CentrifyPasswordProvider extends ConfigurablePasswordProvider {

    public CentrifyPasswordProvider(PasswordUtil util) {
        super(util);
    }

    public CentrifyPasswordProvider(PasswordUtil util, boolean ignoreUnknown) {
        super(util, ignoreUnknown);
    }

    @Override
    public boolean hasPassword(String user) {
        Long id = util.userId(user);
        return id != null;
    }

    @Override
    public Boolean checkPassword(String user, String password, boolean readOnly) {

        Long id = util.userId(user);
        if (id == null || password == null || password.equals("")) {
            return false;
        }

        String line;
        String command = "sh authCentrify.sh " + user + " " + password;
        log.info(String.format("CENTRIFY: command = %s", command));

        log.error(command);
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec(command);
            pr.waitFor();
            BufferedReader is = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String item = is.readLine();
            log.info(String.format("CENTRIFY: item = %s", item));

            if (item != null) {
                log.error("centrify");
                log.error(item);
                if (item.equals("OK")) {
                    loginAttempt(user, true);
                    return true;
                }
            }
        } catch (InterruptedException ex) {
            String errorMessage = "The command [" + command
                    + "] did not complete due to an unexpected interruption.";
            log.error(errorMessage, ex);
            throw new RuntimeException(errorMessage, ex);
        } catch (IOException ex) {
            String errorMessage = "The command [" + command
                    + "] did not complete due to an IO error.";
            log.error(errorMessage, ex);
            throw new RuntimeException(errorMessage, ex);
        }
        return super.checkPassword(user, password, readOnly);

    }

}