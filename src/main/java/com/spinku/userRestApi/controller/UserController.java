package com.spinku.userRestApi.controller;

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
import com.spinku.userRestApi.entity.user.EntityUsers;
import com.spinku.userRestApi.service.ContactService;
import com.spinku.userRestApi.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSONObject;

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
        System.out.println("userService 1:" + userService);
        System.out.println("userService" + userService.getAllUser());
        return userService.getAllUser();
    }

    @PostMapping(path = "/api/login")
    public String login(@RequestBody Ofuser login) throws ServletException {
//    public void login(@RequestBody Ofuser login) throws ServletException {

//	    
        if (login.getEmail() == null || login.getEncryptedpassword() == null) {
            throw new ServletException("Please fill in email and password");
//	    message ="Please fill in email and password.";
        }

        email = login.getEmail();
        password = login.getEncryptedpassword();
        username = login.getUsername();

        System.out.println("email" + email + "-password" + password);
        List<Ofuser> OfuserList = userService.findByEmail(email);
        System.out.println("OfuserList" + OfuserList);

        if (OfuserList == null) {
//	    	   throw new ServletException("User email not found.");
            message = "User email not found.";
            jsonobj.put("typ", type);
            jsonobj.put("alg", sing);
            jsonobj.put("token", jwtToken);
            jsonobj.put("message", message);
//
        }
        pwd = OfuserList.get(0).getEncryptedpassword();
        uname = OfuserList.get(0).getUsername();
        System.out.println("uname" + uname + "-pwd" + pwd);
        System.out.println("username" + username + "-password" + password);
//	if (!password.equals(pwd) || !username.equals(uname)) {
        if (pwd == null || uname == null) {
//	    throw new ServletException("Invalid login. Please check your email and password.");
            message = "Invalid login. Please check your email and password.";
            jsonobj.put("typ", type);
            jsonobj.put("alg", sing);
            jsonobj.put("token", jwtToken);
            jsonobj.put("message", message);

        } else {

            sing = SignatureAlgorithm.HS256;
            jwtToken = Jwts.builder().setSubject(email).claim("roles", role).setIssuedAt(new Date())
                    .signWith((SignatureAlgorithm) sing, "secretkey").compact();
            type = "JWT";
            message = "Success Sign In.";
//            viewAllContact(2l);
//            System.out.println("viewAllContact" + viewAllContact(2l).listIterator());
        }

        jsonobj.put("typ", type);
        jsonobj.put("alg", sing);
        jsonobj.put("token", jwtToken);
        jsonobj.put("message", message);
        jsonobj.put("uname", uname);

        return jsonobj.toString();
    }

    @GetMapping("/api/viewallcontact")
    public List<EntityContacts> viewAllContact(Long id) {
        id = 2l;
//        System.out.println("contactService 1:" + contactService);
//        System.out.println("contactService :" + contactService.getAllContact());
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
