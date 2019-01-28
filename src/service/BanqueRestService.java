package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/banque")
public class BanqueRestService {
	
	private static Map<Integer, Compte> comptes= new HashMap<>();
	
	
	@GET
	@Path("/conversion/{montant}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public double conversion(@javax.ws.rs.PathParam(value="montant")double mt){
	return mt*11;
}
	
	@GET
	@Path("/comptes/{code}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public Compte getCompte(@javax.ws.rs.PathParam(value="code")int code){
	return comptes.get(code);
	
}
	@GET
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_JSON})

public List<Compte> listComptes(){
	//List<Compte> list=new ArrayList<>();

	return new ArrayList<>(comptes.values());
	
}
	@POST
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_JSON})
	public Compte save(Compte cp){
		cp.setDateCreation(new Date());
		comptes.put(cp.getCode(), cp);
		return cp;
	}
	
	@PUT
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte update(Compte cp,@javax.ws.rs.PathParam("code")int code){
		comptes.put(code, cp);
		return cp;
	}
	
	
	@DELETE
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(Compte cp,@javax.ws.rs.PathParam("code")int code){
		comptes.remove(code);
		return true;
	}
}
