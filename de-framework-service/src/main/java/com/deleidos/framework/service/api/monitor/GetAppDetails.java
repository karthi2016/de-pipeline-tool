package com.deleidos.framework.service.api.monitor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.deleidos.analytics.websocket.api.BaseWebSocketMessage;
import com.deleidos.framework.monitoring.MonitoringUtil;
import com.deleidos.framework.service.config.ServiceConfig;

/**
 * Get some extra details about an app given its id
 * 
 * @author mollotb
 */
public class GetAppDetails extends BaseWebSocketMessage {

	private String request, id;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	@Path("/getAppDetails")
	@GET
	public void processMessage() throws Exception {
		if (id != null && !id.equals("")) {
			MonitoringUtil util = new MonitoringUtil(ServiceConfig.getInstance().getHadoopNameNodeHostname());
			sendResponse(util.getAppDetails(id));
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
