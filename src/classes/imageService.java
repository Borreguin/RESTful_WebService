package classes;


import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Path("/ImageService")
public class imageService {

    private Conf_global glb = new Conf_global();

    @GET
    @Path("/images/{imageName}")
    @Produces({"image/png", "image/jpeg", "image/gif"})
    public Response getImage(@PathParam("imageName") String imageName) throws IOException {

        String path = glb.root() + "/Resources/images/" + imageName;
        BufferedImage image = ImageIO.read(new File(path));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();

        // uncomment line below to send non-streamed
        // return Response.ok(imageData).build();

        // uncomment line below to send streamed
        return Response.ok(new ByteArrayInputStream(imageData)).build();
    }
}
