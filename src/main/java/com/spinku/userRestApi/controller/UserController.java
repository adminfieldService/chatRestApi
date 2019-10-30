package com.spinku.userRestApi.controller;

import com.google.gson.Gson;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spinku.userRestApi.entity.Ofuser;
import com.spinku.userRestApi.entity.user.EntityContacts;
import com.spinku.userRestApi.service.ContactService;
import com.spinku.userRestApi.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSONObject;
//import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UserController {

//    @Qualifier("contactService")
//    private final ContactService contactService;
//    @Qualifier("userService")
//    private final UserService userService;
/*      */
    private final UserService userService;
    private final ContactService contactService;
//

    @Autowired
    UserController(UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;

    }
//    @Autowired
//    private UserService userService;
//    private ContactService contactService;

    /**/
//    String jwtToken = "";
//    Object sing = "";
//    String role = "user";
//    String message = "";
//    String type = "";
//    String pwd = "";
//    String uname = "";
//    String email = "";
//    String password = "";
//    String username = "";
//    JSONObject jsonobj = new JSONObject();

    /**/
    /**
     *
     * @param user
     */
    @PostMapping("/api/createuser")
    public void createNewUser(@Valid @RequestBody Ofuser user) {
        userService.addUser(user);
    }

    @PutMapping("/api/changeuser")
    public void changeExistingUser(@Valid @RequestBody Ofuser user) {
        userService.modifyUser(user);
    }

    @DeleteMapping("/api/removeuser/{id}")
    public void removeUser(@PathVariable(value = "id") long userId) {
        userService.removeUser(userId);
    }

    @GetMapping("/api/viewsingleuser/{id}")
    public Ofuser viewUserById(@PathVariable(value = "id") long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/api/viewalluser")
    public List<Ofuser> viewAllUser() {
//        System.out.println("userService 1:" + userService);
//        System.out.println("userService" + userService.getAllUser());
        return userService.getAllUser();
    }

    @PostMapping(path = "/api/login")
//    public String login(@RequestBody Ofuser login) throws ServletException {
    @ResponseBody
    public String login(@RequestBody Ofuser login) throws ServletException {
        String jwtToken = "";
        Object sing = "";
        String role = "user";
        String message = "";
        String type = "";
        String pwd = "";
        String uname = "";
        String email = "";
        String password = "";
        String username = "";
        JSONObject jsonobj = new JSONObject();
//	    
        if (login.getEmail() == null || login.getEncryptedpassword() == null) {
            throw new ServletException("Please fill in email and password");
//	    message ="Please fill in email and password.";
        }

        email = login.getEmail();
        password = login.getEncryptedpassword();
        username = login.getUsername();
        List<Ofuser> OfuserList = null;
//        
        if (email.isEmpty() || password.isEmpty() || email.contentEquals("") || password.contentEquals("") || username.isEmpty() || username.contentEquals("")) {
            message = "Please fill in email and password";
            jsonobj.put("typ", type);
            jsonobj.put("alg", sing);
            jsonobj.put("token", jwtToken);
            jsonobj.put("message", message);
//
            return jsonobj.toString();
        } else {
            System.out.println("email" + email + "-password" + password);
            OfuserList = userService.findByEmail(email);
            System.out.println("OfuserList" + OfuserList);
        }

        if (OfuserList == null || OfuserList.isEmpty()) {
            message = "User email not found.";
            jsonobj.put("typ", type);
//            jsonobj.put("alg", sing);
            jsonobj.put("token", jwtToken);
            jsonobj.put("message", message);
//
            return jsonobj.toString();
        } else {
            pwd = OfuserList.get(0).getEncryptedpassword();
            uname = OfuserList.get(0).getUsername();
            System.out.println("uname" + uname + "-pwd" + pwd);
            System.out.println("username" + username + "-password" + password);
//        }
//	if (!password.equals(pwd) || !username.equals(uname)) {
            if (pwd == null || uname == null) {//|| email.isEmpty() || password.isEmpty() || email.contentEquals("") || password.contentEquals("")
//	    throw new ServletException("Invalid login. Please check your email and password.");
                message = "Invalid login. Please check your email and password.";
                jsonobj.put("typ", type);
//                jsonobj.put("alg", sing);
                jsonobj.put("token", jwtToken);
                jsonobj.put("message", message);

                return jsonobj.toString();

            } else {

                sing = SignatureAlgorithm.HS256;
                jwtToken = Jwts.builder().setSubject(email).claim("roles", role).setIssuedAt(new Date())
                        .signWith((SignatureAlgorithm) sing, "secretkey").compact();
                type = "JWT";
                message = "Success Sign In.";

//            System.out.println("viewAllContact" + viewAllContact(2l).listIterator());
                getContact(jsonobj, 2l, type, sing, jwtToken, message, uname);
            }
            return jsonobj.toString();
        }

//        jsonobj.put("typ", type);
//        jsonobj.put("alg", sing);
//        jsonobj.put("token", jwtToken);
//        jsonobj.put("message", message);
//        jsonobj.put("uname", uname);
    }

//    @GetMapping("/api/getContact")
//    public List<EntityContacts> viewAllContact(Long id, String type, Object o, String token, String message, String uname) {
//    @ResponseBody
    public String getContact(JSONObject json, Long id, String type, Object o, String token, String message, String uname) {
//        id = 2l;
        System.out.println("getContact id:" + id);
        String contacts = String.valueOf(contactService.getAllContact(id));
        //        System.out.println(" viewAllContact :" + id + ";" + type + ";" + o + ";" + token + ";" + message + ";" + uname);
        json.put("token", token);
        json.put("message", message);
        json.put("uname", uname);
//        json.put("contacts", contacts);
        json.put("nilai", contactService.getAllContact(id));
        return json.toString();
//        return contactService.getAllContact(id);
    }

//    @GetMapping("/api/viewallcontact")
    @RequestMapping(value = "/api/viewallcontact", method = RequestMethod.GET)
    @ResponseBody
    public List<EntityContacts> viewAllContact(Long id) {
//    public String viewAllContact(Long id) {
        id = 2l;
        System.out.println("contactService id:" + id);
//       
//        String json = new Gson().toJson(contactService.getAllContact(id));

//        return json;
        return contactService.getAllContact(id);
    }

    @PostMapping("/api/addcontact")
    public void addContact(JSONObject dataJson, EntityContacts dataContact) {
        dataJson.getString("id");
        contactService.addContact(dataContact);
    }

//    @GetMapping("/api/alluser")
//    public List<EntityUsers> allUser() {
//        return contactService.getAllUser();
//    }
//    @GetMapping("/api/data")
//    public String getDataFile() {
//
//        String message = "";
//        String jwtToken = "";
//        Object sing = "";
//        String email = "";
//        String type = "";
//        String role = "user";
//        JSONObject jsonobj = new JSONObject();
////        
////         System.out.println("contactService" + contactService.getAllContact());
//        sing = SignatureAlgorithm.HS256;
//        jwtToken = Jwts.builder().setSubject(email).claim("roles", role).setIssuedAt(new Date())
//                .signWith((SignatureAlgorithm) sing, "secretkey").compact();
//        type = "JWT";
//        message = "Hello Wolrd";
//        jsonobj.put("typ", type);
//        jsonobj.put("message", message);
//        jsonobj.put("token", jwtToken);
//
//        return jsonobj.toString();
//    }
}
