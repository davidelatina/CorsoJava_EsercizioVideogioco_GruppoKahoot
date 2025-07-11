public class SessionManager {
    static private SessionManager currentSession;

    private SessionManager(){};

    public static SessionManager instanceSessionManager(){
        if(currentSession==null){
            currentSession = new SessionManager();
        }
        return currentSession;
    }
}
