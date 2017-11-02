package Test;

import UserManagement.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;



public class WebServiceTester {

    // for this test is necessary this dependence:
    // org.glassfish.jersey.core:jersey-client:2.0
    private Client client;
    private String REST_SERVICE_URL = "http://localhost:5050/WebServer/UserService/users";
    private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    private void init(){
        this.client = ClientBuilder.newClient();
    }

    public static void main(String[] args){
        WebServiceTester tester = new WebServiceTester();
        //initialize the tester
        tester.init();
        //test all users Web Service Method
        //test get all users Web Service Method
        tester.testGetAllUsers();
        //test get user Web Service Method
        tester.testGetUser();
        //test update user Web Service Method
        tester.testUpdateUser();
        //test delete user Web Service Method
        tester.testDeleteUser();
        //test add user Web Service Method
        tester.testAddUser();

    }

    //Test: Get list of all users
    //Test: Check if list is not empty
    private void testGetAllUsers(){
        GenericType<List<User>> list = new GenericType<List<User>>() {};
        String result = FAIL;
        try{
        List<User> users = client
                .target(REST_SERVICE_URL)
                .request(MediaType.APPLICATION_XML)
                .get(list);
            result = PASS;
            if(users.isEmpty()){
                result = FAIL;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Test case name: testGetAllUsers, Result: " + result );
    }
    //Test: Get User of id 1
    //Test: Check if user is same as sample user
    private void testGetUser(){
        User SampleUser = new User();
        SampleUser.setId(1);
        String result = FAIL;

        try {
            User user = client
                    .target(REST_SERVICE_URL)
                    .path("/{userid}")
                    .resolveTemplate("userid", 1)
                    .request(MediaType.APPLICATION_XML)
                    .get(User.class);

            if(SampleUser.getId() == user.getId()){
                result = PASS;
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Test case name: testGetUser, Result: " + result);
    }

    //Test: Update User of id 1
    //Test: Check if result is success XML.
    private void testUpdateUser() {
        Form form = new Form();
        form.param("id", "1");
        form.param("name", "naresh");
        form.param("profession", "teacher");

        String callResult = client
                .target(REST_SERVICE_URL)
                .request(MediaType.APPLICATION_XML)
                .post(Entity.entity(form,
                        MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                        String.class);
    }

    //Test: Add User of id 2
    //Test: Check if result is success XML.
    private void testAddUser(){
        Form form = new Form();
        form.param("id", "2");
        form.param("name", "Jack Sp");
        form.param("profession", "Pirate");

        String callResult = client
                .target(REST_SERVICE_URL)
                .request(MediaType.APPLICATION_XML)
                .post(Entity.entity(form,
                        MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                        String.class);

        String result = PASS;
        if(!SUCCESS_RESULT.equals(callResult)){
            result = FAIL;
        }

        System.out.println("Test case name: testAddUser, Result: " + result );
    }

    //Test: Delete User of id 2
    //Test: Check if result is success XML.
    private void testDeleteUser(){
        String callResult = client
                .target(REST_SERVICE_URL)
                .path("/{userid}")
                .resolveTemplate("userid", 2)
                .request(MediaType.APPLICATION_XML)
                .delete(String.class);

        String result = PASS;
        if(!SUCCESS_RESULT.equals(callResult)){
            result = FAIL;
        }

        System.out.println("Test case name: testDeleteUser, Result: " + result );
    }

}

