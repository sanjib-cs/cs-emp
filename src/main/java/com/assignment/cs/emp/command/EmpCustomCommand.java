package com.assignment.cs.emp.command;

import java.util.List;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAuthenticatedDbAbstract;

public class EmpCustomCommand extends OServerCommandAuthenticatedDbAbstract {
	private static final String[] NAMES = { "GET|query/*" };

	@Override
	public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception {

	    String[] urlParts = checkSyntax(
	        iRequest.url,
	        4,
	        "Syntax error: query/<database>/sql/<query-text>[/<limit>][/<fetchPlan>].<br/>Limit is optional and is setted to 20 by default. Set expressely to 0 to have no limits.");

	    int limit = urlParts.length > 4 ? Integer.parseInt(urlParts[4]) : 20;
	    String fetchPlan = urlParts.length > 5 ? urlParts[5] : null;
	    String text = urlParts[3];

	    iRequest.data.commandInfo = "Query";
	    iRequest.data.commandDetail = text;

	    ODatabaseDocumentTx db = null;

	    List<OIdentifiable> response;

	    try {
	      db = (ODatabaseDocumentTx) getProfiledDatabaseInstance(iRequest);
	      response = (List<OIdentifiable>) db.command(new OSQLSynchQuery<OIdentifiable>(text, limit).setFetchPlan(fetchPlan)).execute();

	    } finally {
	      if (db != null) {
	        db.close();
	      }
	    }

	    iResponse.writeRecords(response, fetchPlan);
	    return false;
	  
	}

	@Override
	public String[] getNames() {
		return NAMES;
	}

}
