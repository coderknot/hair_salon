import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String name = request.queryParams("stylist-name");
      Stylist newStylist = new Stylist(name);
      newStylist.save();

      String url = String.format("/");
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylist_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylist_id")));
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylist_id/clients/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String name = request.queryParams("client-name");
      String phone = request.queryParams("client-phone");
      String email = request.queryParams("client-email");
      int stylistId = Stylist.find(Integer.parseInt(request.params(":stylist_id"))).getId();;

      Client newClient = new Client(name, phone, email, stylistId);
      newClient.save();

      String url = String.format("/stylists/" + stylistId);
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylist_id/clients/:client_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params(":client_id")));
      model.put("client", client);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylist_id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylist_id")));
      model.put("stylist", stylist);
      model.put("template", "templates/stylist-update.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("stylists/:stylist_id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String newName = request.queryParams("stylist-name-update");
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylist_id")));
      stylist.updateName(newName);

      String url = String.format("/stylists/" + stylist.getId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
