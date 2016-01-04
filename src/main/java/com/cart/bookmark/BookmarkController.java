package main.java.com.cart.bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hshs on 2015. 9. 26..
 * 웹페이지 완성 후  method= RequestMethod.POST 추가하기
 */

@Controller
//@RequestMapping("/1/bookmark")
public class BookmarkController {

    @Autowired BookmarkService bookmarkService;

    @RequestMapping(value="/add")
    public @ResponseBody Bookmark add(
            HttpServletRequest request,
            @RequestParam("name") String name,
            @RequestParam("url") String url,
            @RequestParam("folderId") int folderId) {

        Bookmark bookmark = new Bookmark();
        bookmark.setUrl(url);
        bookmark.setName(name);
        bookmark.setFolderId(folderId);

        bookmarkService.add(bookmark);
        return bookmark;

//        String userId = "tmpUserId";
//
//        String folderPath = (String) request.getAttribute(
//                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//
//
//        Bookmark bookmark = new Bookmark();
//        System.out.println(userId);
//        System.out.println(folderPath);
//        System.out.println(bookmarkName);
//
//
//        bookmark.setFolderId(1);
//        bookmark.setName("name");
//        bookmark.setUrl("url");
//        Session hbSession = null;
//        Transaction tx = null;
//        try {
//            hbSession = HibernateUtil.getSessionFactory().openSession();
//            tx = hbSession.beginTransaction();
//
//            User user2 = (User) hbSession.get(User.class, "aa");
//            user2.setPassword("update");
//            hbSession.save(bookmark);
////            hbSession.save(folder);
//
//            System.out.println("succ");
//            tx.commit();
//        } catch (Exception ex) {
//            if (tx != null) tx.rollback();
//        } finally {
//            hbSession.close();
//        }
//
//        String message = "Hello, Spring 3.0!";
//        System.out.println(message);
//        return new ModelAndView("home");
    }

    @RequestMapping(value="/edit", method= RequestMethod.POST)
    public ModelAndView edit(
            HttpServletRequest request,
            @RequestParam("bookmarkId") String bookmarkId,
            @RequestParam("bookmarkName") String bookmarkName,
            @RequestParam("forderId") String forderId ) {

        System.out.println(bookmarkId);
        System.out.println(bookmarkName);
        System.out.println(forderId);
        return new ModelAndView("home");
    }

    @RequestMapping(value="/remove", method= RequestMethod.POST)
    public ModelAndView remove(
            HttpServletRequest request,
            @RequestParam("bookmarkId") String bookmarkId,
            @RequestParam("forderId") String forderId ) {


        System.out.println(bookmarkId);
        System.out.println(forderId);
        return new ModelAndView("home");
//        Session hbSession = null;
//        Transaction tx = null;
//
//        Bookmark bookmark = new Bookmark();
//        bookmark.setName("aabb");
//        bookmark.setUrl("aabb");
//
//        Folder folder = new Folder();
//        folder.setName("test3");
//
//        User user = new User();
//        user.setId("aa");
//        user.setPassword("ccc");
//
//        System.out.println(userId);
//
//
//        try {
//            hbSession = HibernateUtil.getSessionFactory().openSession();
//            tx = hbSession.beginTransaction();
//
////            User user2 = (User) hbSession.get(User.class, "aa");
////            user2.setPassword("update");
////            hbSession.save(bookmark);
////            hbSession.save(folder);
//
//            System.out.println("succ");
//            tx.commit();
//        } catch (Exception ex) {
//            if (tx != null) tx.rollback();
//        } finally {
//            hbSession.close();
//        }
//
//        String message = "Hello, Spring 3.0!";
//        System.out.println(message);
//        return new ModelAndView("home");
    }
}