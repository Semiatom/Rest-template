package main;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

@Component
public class Communication {

@Autowired
private RestTemplate restTemplate;
private final String URL = "http://94.198.50.185:7081/api/users";

    public List<User> getUsers(){

        ResponseEntity<List<User>> response =  restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        List<User> users = response.getBody();
        return users;
    }

    public String getCookie (){
        ResponseEntity<List<User>> response =  restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        HttpHeaders headers = response.getHeaders();
        String set_cookie = headers.getFirst(headers.SET_COOKIE);
        set_cookie = set_cookie.substring(0, 43);
        return set_cookie;
    }

//    public String createUser(User user, String cookie) {
//    HttpHeaders httpHeaders = new HttpHeaders();
//    httpHeaders.add("Cookie", cookie);
//
//    HttpEntity entity = new HttpEntity<>(user, httpHeaders);
//
//    ResponseEntity response = restTemplate.exchange(URL, HttpMethod.POST, entity, User.class);
//    User userCreated = (User) response.getBody();
//        System.out.println(userCreated + " is created");
//      return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
//}


    public String createUser(User user, String cookie) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", cookie);
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);

        String response =  restTemplate.exchange(
                URL, HttpMethod.POST, entity, String.class).getBody();
        System.out.println(response);
        return response;
    }

    public String editUser(User user, String cookie) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", cookie);
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);

        String response =  restTemplate.exchange(
                URL, HttpMethod.PUT, entity, String.class).getBody();
        System.out.println(response);
        return response;
    }
//    public String deleteUser(int id, String cookie) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add("Cookie", cookie);
//        HttpEntity<User> entity = new HttpEntity<>(headers);
//        String response =  restTemplate.exchange(
//                URL+ "/"+ id, HttpMethod.DELETE, entity, String.class).getBody();
//        System.out.println(response);
//
//        return response;
//
//    }

//    public String common (int id, User user1, User user2,String cookie){
//
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add("Cookie", cookie);
//        HttpEntity<User> entity = new HttpEntity<User>(user2,headers);
//
//        String response =  restTemplate.exchange(
//                URL, HttpMethod.POST, entity, String.class).getBody();
//        System.out.println(response);
//        return response;
//
//    }

}
