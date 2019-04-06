package pl.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController(){
        listPerson = generateList();
    }




    @GetMapping("basic")
    public String basic(Model model) {
         String firstName = "Jan";
         String lastName = "Kowalski";
         model.addAttribute("fName", firstName);
         model.addAttribute("lName", lastName);


        Person person = new Person();
        person.setFirstName("Jacek");
        person.setLastName("Nowak");
        person.setPhoneNUmber("666-666-666");
        person.setSalary(9999.99);
        person.setVisible(true);
        model.addAttribute("person", person);
        return  "basicTemplate";
    }

    @GetMapping("iteration")
    public String iteration(Model model){
        model.addAttribute("list", listPerson);
        return "interationTemplate";
    }




    @GetMapping("links")
    public String links(Model model){
        return "linksTemplate";
    }



    @GetMapping("inter")
    public String inter (Model model){
        return "interTemplate";
    }



    @GetMapping("forms")
    public String froms(Model model){
        model.addAttribute("person", new Person());
        return "formsTemplate";
    }


    @PostMapping("formsSave")
    public String formsSave(Person person, Model model){
        listPerson.add(person);
        return "successTemplate";

    }



    @GetMapping("fragments")
    public String fragments(Model model){
        return "fragments/fragmentsTemplate";
    }


    @GetMapping("fragments2")
    public String fragments2(Model model){
        return "fragments/fragmentsTemplate2";
    }





    private List<Person> generateList(){
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("Jacek");
        person1.setLastName("Nowak");
        person1.setPhoneNUmber("666-666-666");
        person1.setSalary(9999.99);
        person1.setVisible(true);


        Person person2 = new Person();
        person2.setFirstName("Adam");
        person2.setLastName("Kowalski ");
        person2.setPhoneNUmber("665-666-666");
        person2.setSalary(9669.99);
        person2.setVisible(false);

        Person person3 = new Person();
        person3.setFirstName("Placek");
        person3.setLastName("Balatzar");
        person3.setPhoneNUmber("666-111-666");
        person3.setSalary(1000.9977);
        person3.setVisible(true);


        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        return persons;
    }





    @GetMapping("basic1")
    public String basic1(Model model){
        String firstName = "Jan";
        String lastName = "Kowalski";
        model.addAttribute("fName1", firstName);
        model.addAttribute("lName1", lastName);
        return "basicTemplate";
    }



}
