public class RequestHandler {
    public String handle(String request){
        System.out.println(request);
        return "response "+ request;
    }
}
