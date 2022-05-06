package note.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

@WebListener
public class OnlineCounterListener implements HttpSessionListener, HttpSessionAttributeListener {

    Set<String> onlineUsers = new HashSet<>();

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String userName = (String) se.getSession().getAttribute("me");
        if (userName != null){
            onlineUsers.add(userName);
            se.getSession().setAttribute("online",onlineUsers);
        }
        System.out.println("lis"+userName);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeRemoved(se);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeReplaced(se);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        onlineUsers.remove((String) se.getSession().getAttribute("me"));
        se.getSession().setAttribute("online",onlineUsers);
    }
}
