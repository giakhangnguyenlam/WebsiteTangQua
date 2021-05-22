package com.swcat.giftapp.REST.comments;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.swcat.giftapp.DAO.comments.commentService;
import com.swcat.giftapp.Models.gPackComments.MailCommentModel;
import com.swcat.giftapp.Models.gPackComments.gPackCommentsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ResponseBody;





@Path("/comments")
public class commentsREST {
    @Autowired
    private commentService commentService;    


    @GET
    @Path("/listComments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<gPackCommentsModel> getAllgPackComments()
    {
        return commentService.listComments();
    }

    @POST
    @Path("/addComment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrderComments(gPackCommentsModel giftpackCommentModel)
    {
        boolean exist=commentService.existComments(giftpackCommentModel.getGiftpackId());
        if(!exist)
        {
            commentService.addPackCommentsModel(giftpackCommentModel);
            return Response.status(200).entity("Add Comment sucess").build();
        }
        else
        return Response.status(400).entity("Add comment unsucess").build();
    }



    @PUT
    @Path("/update/{giftpackId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrderComments(@PathParam("giftpackId") int giftpackId,gPackCommentsModel giftpackCommentModel)
    {
        boolean exist=commentService.existComments(giftpackId);
        if(exist)
        {
            commentService.updatePackComments(giftpackCommentModel);;
            return Response.status(200).entity("Update success").build();
        }
        else
        {
            return Response.status(404).entity("Update unsucess").build();
        }
    }

    @DELETE
    @Path("/delete/{giftpackId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrderComments(@PathParam("giftpackId") int giftpackId)
    {
        boolean exist=commentService.existComments(giftpackId);
        if(exist)
        {
            commentService.deletePackComments(giftpackId);;
            return Response.status(200).entity("Delete success").build();
        }
        return Response.status(404).entity("Delete unsuccess").build();
    }
    @POST
    @Path("/resolveComment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendEmailResovleComments(MailCommentModel mailCommentModel)
    {
        try{
            commentService.sendEmailResloveComment(mailCommentModel);
            return Response.status(200).entity("Mail sent").build();
        }catch(MailException exception)
        {
            return Response.status(400).entity("Sent mail fail").build();
        }
        
    }
}
