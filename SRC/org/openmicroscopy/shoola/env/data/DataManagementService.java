/*
 * org.openmicroscopy.shoola.env.data.DataManagementService
 *
 *------------------------------------------------------------------------------
 *
 *  Copyright (C) 2004 Open Microscopy Environment
 *      Massachusetts Institute of Technology,
 *      National Institutes of Health,
 *      University of Dundee
 *
 *
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *------------------------------------------------------------------------------
 */

package org.openmicroscopy.shoola.env.data;

//Java imports
import java.util.List;

//Third-party libraries

//Application-internal dependencies
import org.openmicroscopy.shoola.env.data.model.AnalysisChainData;
import org.openmicroscopy.shoola.env.data.model.AnalysisLinkData;
import org.openmicroscopy.shoola.env.data.model.AnalysisNodeData;
import org.openmicroscopy.shoola.env.data.model.ChainExecutionData;
import org.openmicroscopy.shoola.env.data.model.ChannelData;
import org.openmicroscopy.shoola.env.data.model.DataObject;
import org.openmicroscopy.shoola.env.data.model.DatasetData;
import org.openmicroscopy.shoola.env.data.model.DatasetSummary;
import org.openmicroscopy.shoola.env.data.model.FormalInputData;
import org.openmicroscopy.shoola.env.data.model.FormalOutputData;
import org.openmicroscopy.shoola.env.data.model.ImageData;
import org.openmicroscopy.shoola.env.data.model.ImageSummary;
import org.openmicroscopy.shoola.env.data.model.ModuleData;
import org.openmicroscopy.shoola.env.data.model.ModuleExecutionData;
import org.openmicroscopy.shoola.env.data.model.ModuleCategoryData;
import org.openmicroscopy.shoola.env.data.model.NodeExecutionData;
import org.openmicroscopy.shoola.env.data.model.PixelsDescription;
import org.openmicroscopy.shoola.env.data.model.ProjectData;
import org.openmicroscopy.shoola.env.data.model.ProjectSummary;
import org.openmicroscopy.shoola.env.data.model.SemanticTypeData;
/** 
 * 
 * @author  Jean-Marie Burel &nbsp;&nbsp;&nbsp;&nbsp;
 * 				<a href="mailto:j.burel@dundee.ac.uk">j.burel@dundee.ac.uk</a>
 * @author  <br>Andrea Falconi &nbsp;&nbsp;&nbsp;&nbsp;
 * 				<a href="mailto:a.falconi@dundee.ac.uk">
 * 					a.falconi@dundee.ac.uk</a>
 * @version 2.2 
 * <small>
 * (<b>Internal version:</b> $Revision$ $Date$)
 * </small>
 * @since OME2.2
 */


public interface DataManagementService
{
	
	/**
	 * Create, if none provided, two new protos and fill them up
	 * with data retrieved form OMEDS Project objects.
	 * Each project proto object is linked to a list of dataset proto 
	 * objects.
	 * 
	 * @param pProto	project proto.
	 * @param dProto	dataset proto.
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
    public List retrieveUserProjects(ProjectSummary pProto, 
    								DatasetSummary dProto)
		throws DSOutOfServiceException, DSAccessException;
    								
	/**
	 * Retrieve all user's projects.
	 * Create a list of project summary DataObjects filled up with 
	 * data retrieved from an OMEDS project objects.
	 * Each project summary object is linked to a list of dataset summary 
	 * objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
    public List retrieveUserProjects()
		throws DSOutOfServiceException, DSAccessException;
    
	/**
	 * Create, if none provided, two new protos and fill them up
	 * with data retrieved form OMEDS Project objects.
	 * Each project proto object is linked to a list of dataset proto 
	 * objects. Not that the dataset are dataset data objects, not dataset summary
	 * 
	 * @param pProto	project proto.
	 * @param dProto	dataset proto.
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
    public List retrieveUserProjectsWithDatasetData(ProjectSummary pProto, 
    									DatasetData dProto)
		throws DSOutOfServiceException, DSAccessException;
    
    
    /**
	 * Create, if none provided, two new protos and fill them up
	 * with data retrieved form OMEDS Project objects.
	 * Each project proto object is linked to a list of dataset proto 
	 * objects. Not that the dataset are dataset data objects, not dataset summary
	 * 
	 * @param pProto	project proto.
	 * @param dProto	dataset proto.
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
    public List retrieveUserProjectsWithDatasetData()
		throws DSOutOfServiceException, DSAccessException;
    
	/**
	 * Create, if none provided, two new protos and fill them up
	 * with data retrieved form OMEDS Dataset objects.
	 * 
	 * @param dProto	dataset proto.
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
	public List retrieveUserDatasets(DatasetSummary dProto)
		throws DSOutOfServiceException, DSAccessException;
    								
	/**
	 * Retrieve all user's datasets.
	 * Create a list of dataset summary DataObjects filled up with 
	 * data retrieved from an OMEDS dataset objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
    public List retrieveUserDatasets()
		throws DSOutOfServiceException, DSAccessException;
     
    /**
	 * Create, if none provided, two new protos and fill them up
	 * with data retrieved form OMEDS Dataset objects.
	 * 
	 * @param dProto	dataset proto
	 * @param iProto image proto
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
	public List retrieveUserDatasets(DatasetData dProto,
				ImageSummary iProto)
		throws DSOutOfServiceException, DSAccessException;
    								
    
	/**
	 * Create, if none provided, two new protos and fill them up
	 * with data retrieved form OMEDS Dataset objects.
	 * 
	 * @param dProto	dataset proto.
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
	public List retrieveUserImages(ImageSummary iProto)
		throws DSOutOfServiceException, DSAccessException;
    								
	/**
	 * Retrieve all user's datasets.
	 * Create a list of dataset summary DataObjects filled up with 
	 * data retrieved from an OMEDS dataset objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveUserImages()
		throws DSOutOfServiceException, DSAccessException; 

	/**
	 * Create, if none provided, a DataObject and fill it up with
	 * data retrieved from an OMEDS Project object.
	 * 
	 * @param projectID		projectID.
	 * @param retVal		DataObject to fill up.
	 * @return projet data object.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */								
    public ProjectData retrieveProject(int projectID, ProjectData retVal)
		throws DSOutOfServiceException, DSAccessException;
    
	/**
	 * Create a DataObject and fill it up with
	 * data retrieved from an OMEDS Project object.
	 * 
	 * @param projectID		projectID.
	 * @return project data object.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
	 */
	public ProjectData retrieveProject(int projectID)
		throws DSOutOfServiceException, DSAccessException;
	
	/**
	 * Create, if none provided, a DataObject and fill it up with
	 * data retrieved from an OMEDS Dataset object.
	 * 
	 * @param datasetID		datasetID.
	 * @param retVal	DataObject to fill up.
	 * @return dataset data object.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
	 */
    public DatasetData retrieveDataset(int datasetID, DatasetData retVal)
		throws DSOutOfServiceException, DSAccessException;
    
	/**
	 * Create a DataObject and fill it up with
	 * data retrieved from an OMEDS Dataset object.
	 * 
	 * @param datasetID		datasetID.
	 * @return dataset data object.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
	 */
	public DatasetData retrieveDataset(int datasetID)
		throws DSOutOfServiceException, DSAccessException;
	
	/**
	 * Create, if none provided, a DataObject and fill it up with
	 * data retrieved from an OMEDS Image object.
	 * 
	 * @param id		imageID.
	 * @param retVal	DataObject to fill up.
	 * @return image data object.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
	 */
    public ImageData retrieveImage(int id, ImageData retVal)
		throws DSOutOfServiceException, DSAccessException;
    
	/**
	* Create a DataObject and fill it up with
	* data retrieved from an OMEDS Image object.
	* 
	* @param id		imageID.
	* @return image data object.
	* @throws DSOutOfServiceException If the connection is broken, or logged in
	* @throws DSAccessException If an error occured while trying to 
	* retrieve data from OMEDS service.  
	*/
	public ImageData retrieveImage(int id)
		throws DSOutOfServiceException, DSAccessException;
	
    /**
     * Retrieve all images linked to a given dataset.
     * Creates a list of image summary objects, object filled up with
     * data retrieved from an OMEDS Image object.
     * 
     * @param datasetID.		
     * @return list of image summary objects.
     * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
     */
    public List retrieveImages(int datasetID)
		throws DSOutOfServiceException, DSAccessException;
	
	/**
	 * Retrieve all images linked to a given dataset.
	 * Create, if none provided, a DataObject and fill it up with
	 * data retrieved from an OMEDS Image object.
	 * 
	 * @param id		imageID.
	 * @param iProto	DataObject used as a prototype.
	 * @return image data object.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
	 */
	public List retrieveImages(int datasetID, ImageSummary iProto)
		throws DSOutOfServiceException, DSAccessException;
		
	/**
	 * Retrieves the common metadata (such as dimensions, type, etc.) associated
	 * to a pixels set.
	 * 
	 * @param pixelsID	The id of the pixels set.
	 * @param imageID	The id of the OME image
	 * @return An object containing the common pixels metadata.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.  
	 */
	public PixelsDescription retrievePixels(int pixelsID, int imageID)
		throws DSOutOfServiceException, DSAccessException;
		
	/**
	 * Retrieve all of the system's analysis modules
	 * Create, if none provided, new protos and fill them up
	 * with data retrieved from OMEDS Modules objects.
	 * Each project proto object is linked to a list of dataset proto 
	 * objects.
	 * 
	 * @param mProto	module proto.
	 * @param mcProto	module category proto.
	 * @param finProto	formal input proto
	 * @param foutProto	formal output proto
	 * @param stProto	Semantic type proto
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
	public List retrieveModules(ModuleData mProto,ModuleCategoryData
			mcProto,FormalInputData finProto,FormalOutputData foutProto,
			SemanticTypeData stProto)
		throws DSOutOfServiceException, DSAccessException;
  								
	/**
	 * Retrieve all of the system's analysis modules categories
	 * Create a list of module category data DataObjects filled up with 
	 * data retrieved from OMEDS module objects.
	 * Each module category object is linked to a lists of modules
	 * 
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveModuleCategories()
		throws DSOutOfServiceException, DSAccessException;

	/**
	 * Retrieve all of the system's analysis modules categories
	 * Create a list of module category data DataObjects filled up with 
	 * data retrieved from OMEDS module objects.
	 * Each module category object is linked to a lists of modules
	 *
	 * @param mcProto	module category proto. 
	 * @param mProto	module proto.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service.
	 */
	public List retrieveModuleCategories(ModuleCategoryData mcProto,
					ModuleData mProto)
		throws DSOutOfServiceException, DSAccessException;
								
	/**
	 * Retrieve all of the system's analysis modules
	 * 
	 * Create a list of module data DataObjects filled up with 
	 * data retrieved from OMEDS module objects.
	 * Each module object is linked to a lists of formal inputs 
	 * and formal outputs.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveModules()
		throws DSOutOfServiceException, DSAccessException;	
	
	/**
	 * Retrieve all of the system's analysis chains
	 * 
	 * Create a list of chain data DataObjects filled up with 
	 * data retrieved from OMEDS chain objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveChains(AnalysisChainData acProto,AnalysisLinkData
			alProto,AnalysisNodeData anProto,ModuleData modProto,
			FormalInputData finProto,FormalOutputData foutProto,
			SemanticTypeData stProto) 
		throws DSOutOfServiceException,DSAccessException;
		
		
	/**
	 * Retrieve all of the system's analysis chains
	 * 
	 * Create a list of chain data DataObjects filled up with 
	 * data retrieved from OMEDS chain objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveChains() 
		throws DSOutOfServiceException,DSAccessException;

	/**
	 * Retrieve all of the system's analysis chains
	 * 
	 * Create a list of chain data DataObjects filled up with 
	 * data retrieved from OMEDS chain objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveChainExecutions(ChainExecutionData ceProto,
			DatasetData dsProto,AnalysisChainData acProto,NodeExecutionData
			neProto,AnalysisNodeData anProto,ModuleData mProto,
			ModuleExecutionData meProto) 
		throws DSOutOfServiceException,DSAccessException;
		
		
	/**
	 * Retrieve all of the system's analysis chain executions
	 * 
	 * Create a list of chain data DataObjects filled up with 
	 * data retrieved from OMEDS chain objects.
	 * 
	 * @return See above.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * retrieve data from OMEDS service. 
	 */
	public List retrieveChainExecutions() 
		throws DSOutOfServiceException,DSAccessException;

	/**
	 * Create a new project.
	 * 
	 * @param projectSummaries	List of project summary object.
	 * @param retVal	DataObject 
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public ProjectSummary createProject(ProjectData retVal, 
										ProjectSummary pProto)
		throws DSOutOfServiceException, DSAccessException;
	
	/**
	 * Create a new dataset.
	 * 
	 * @param projectSummaries	List of project summary objects.
	 * @param imageSummaries	List of image summary objects.
	 * @param retVal			DataObject to fill up.
	 * @param dProto			DataObject prototype.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public DatasetSummary createDataset(List projectSummaries, 
										List imageSummaries,
										DatasetData retVal, 
										DatasetSummary dProto)
			throws DSOutOfServiceException, DSAccessException;
	
	/**
	 * Create a new project.
	 * 
	 * @param retVal	DataObject 
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public ProjectSummary createProject(ProjectData retVal)
		throws DSOutOfServiceException, DSAccessException;
	
	/**
	 * Create a new dataset.
	 * 
	 * @param retVal	DataObject
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public DatasetSummary createDataset(List projectSummaries,
										List imageSummaries,
										DatasetData retVal)
			throws DSOutOfServiceException, DSAccessException;
					
    /**
     * Update a specified project.
     * 
     * @param retVal		DataObject to update.
     * @param dsToRemove	List of dataset summary to remove.
     * @param dsToAdd		List of dataset summary to add. 
     * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
     */
    public void updateProject(ProjectData retVal, List dsToRemove, 
    								List dsToAdd)
		throws DSOutOfServiceException, DSAccessException;
		
	/**
	 * Update a specified dataset.
	 * 
	 * @param retVal		DataObject to update.
     * @param isToRemove	List of image summary to remove.
     * @param isToAdd		List of image summary to add. 
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public void updateDataset(DatasetData retVal, List isToRemove, 
									List isToAdd)
		throws DSOutOfServiceException, DSAccessException;
			
	/**
	 * Update a specified image. 
	 * The DataObject must be an instance of {@link ImageSummary} or 
	 * {@link ImageData}.
	 * 
	 * @param retVal		DataObject to update.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public void updateImage(DataObject retVal)
		throws DSOutOfServiceException, DSAccessException;
		
	/**
	 * Retrieve the data associated to the channels of a specified image.
	 * 
	 * @param imageID		image's ID.
	 * @return retVal		List of channelData objects.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public ChannelData[] getChannelData(int imageID)
		throws DSOutOfServiceException, DSAccessException;	
	
	/**
	 * Update a specified channelData.
	 * 
	 * @param retVal		ChannelData object to update.
	 * @throws DSOutOfServiceException If the connection is broken, or logged in
	 * @throws DSAccessException If an error occured while trying to 
	 * 		   update data from OMEDS service.  
	 */
	public void updateChannelData(ChannelData retVal)	
		throws DSOutOfServiceException, DSAccessException;
	
}
