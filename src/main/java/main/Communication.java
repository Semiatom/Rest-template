package main;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
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

    public String createUser(User user, String cookie) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Cookie", cookie);

    HttpEntity entity = new HttpEntity<>(user, httpHeaders);

    ResponseEntity response = restTemplate.exchange()


    }


    public void editUser(User user) {

    }
    public void deleteUser(User user) {

    }

}
