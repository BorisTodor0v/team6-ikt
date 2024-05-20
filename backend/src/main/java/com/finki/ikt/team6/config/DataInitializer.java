package com.finki.ikt.team6.config;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.job.JobCreateDTO;
import com.finki.ikt.team6.model.dto.user.UserEditDTO;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
import com.finki.ikt.team6.service.CategoryService;
import com.finki.ikt.team6.service.JobService;
import com.finki.ikt.team6.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataInitializer {
    private final UserService userService;
    private final CategoryService categoryService;
    private final JobService jobService;

    public DataInitializer(UserService userService, CategoryService categoryService, JobService jobService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.jobService = jobService;
    }

    /**
        Create dummy data for testing purposes
     */
    @PostConstruct
    public void init(){
        // Users
        /*
        UserRegisterDTO adminDTO = new UserRegisterDTO();
        adminDTO.setUsername("admin");
        adminDTO.setPassword("admin");
        adminDTO.setRepeatPassword("admin");
        adminDTO.setName("Admin");
        adminDTO.setSurname("Admin");
        adminDTO.setEmail("admin@kindly.com");
        adminDTO.setAddress("home");
        userService.register(adminDTO, Role.ADMIN);
        User user = userService.listAll().get(userService.listAll().size()-1);
        UserEditDTO userEditDTO = UserEditDTO.of(user);
        userEditDTO.setMinSalary(10.0);
        userEditDTO.setMaxSalary(15.0);
        userEditDTO.setGrade(3);
        userEditDTO.setOffersPetCare(true);
        userEditDTO.setHighEducation(true);
        userEditDTO.setNonSmoker(true);
        userEditDTO.setComfortableWithPets(true);
        userService.edit(user.getId(), userEditDTO);

         */

        UserRegisterDTO userDTO = new UserRegisterDTO();
        userDTO.setUsername("anastasija.simonova");
        userDTO.setPassword("anastasijasimonova");
        userDTO.setRepeatPassword("anastasijasimonova");
        userDTO.setName("Anastasija");
        userDTO.setSurname("Simonova");
        userDTO.setEmail("anastasija.simonova@example.com");
        userDTO.setAddress("123 Kid Street");
        userService.register(userDTO, Role.USER);
        User user = userService.listAll().get(userService.listAll().size()-1);
        UserEditDTO userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(7);
        userEditDTO.setOffersChildCare(true);
        userEditDTO.setOffersElderCare(false);
        userEditDTO.setOffersPetCare(false);
        userEditDTO.setMinSalary(10.00);
        userEditDTO.setMaxSalary(20.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(false);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(true);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("ines.velmor");
        userDTO.setPassword("inesvelmor");
        userDTO.setRepeatPassword("inesvelmor");
        userDTO.setName("Ines");
        userDTO.setSurname("Velmor");
        userDTO.setEmail("ines.velmor@example.com");
        userDTO.setAddress("456 Senior Blvd");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(8);
        userEditDTO.setOffersChildCare(false);
        userEditDTO.setOffersElderCare(true);
        userEditDTO.setOffersPetCare(false);
        userEditDTO.setMinSalary(15.00);
        userEditDTO.setMaxSalary(25.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(false);
        userEditDTO.setHasCar(false);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("boris.todorov");
        userDTO.setPassword("boristodorov");
        userDTO.setRepeatPassword("boristodorov");
        userDTO.setName("Boris");
        userDTO.setSurname("Todorov");
        userDTO.setEmail("boris.todorov@example.com");
        userDTO.setAddress("789 Animal Ave");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(8);
        userEditDTO.setOffersChildCare(false);
        userEditDTO.setOffersElderCare(false);
        userEditDTO.setOffersPetCare(true);
        userEditDTO.setMinSalary(12.00);
        userEditDTO.setMaxSalary(18.00);
        userEditDTO.setTrainedInFirstAid(false);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(false);
        userEditDTO.setHasCar(true);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("elena.petkova");
        userDTO.setPassword("elenapetkova");
        userDTO.setRepeatPassword("elenapetkova");
        userDTO.setName("Elena");
        userDTO.setSurname("Petkova");
        userDTO.setEmail("elena.petkova@example.com");
        userDTO.setAddress("101 Care Lane");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(9);
        userEditDTO.setOffersChildCare(true);
        userEditDTO.setOffersElderCare(true);
        userEditDTO.setOffersPetCare(false);
        userEditDTO.setMinSalary(20.00);
        userEditDTO.setMaxSalary(30.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(false);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(true);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("iva.milosavljevikj");
        userDTO.setPassword("ivamilosavljevikj");
        userDTO.setRepeatPassword("ivamilosavljevikj");
        userDTO.setName("Iva");
        userDTO.setSurname("Milosavljevikj");
        userDTO.setEmail("iva.milosavljevikj@example.com");
        userDTO.setAddress("202 Care Blvd");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(10);
        userEditDTO.setOffersChildCare(false);
        userEditDTO.setOffersElderCare(true);
        userEditDTO.setOffersPetCare(true);
        userEditDTO.setMinSalary(17.00);
        userEditDTO.setMaxSalary(27.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(false);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("aneta.solunska");
        userDTO.setPassword("anetasolunska");
        userDTO.setRepeatPassword("anetasolunska");
        userDTO.setName("Aneta");
        userDTO.setSurname("Solunska");
        userDTO.setEmail("aneta.solunska@example.com");
        userDTO.setAddress("303 Universal St");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(7);
        userEditDTO.setOffersChildCare(true);
        userEditDTO.setOffersElderCare(true);
        userEditDTO.setOffersPetCare(true);
        userEditDTO.setMinSalary(25.00);
        userEditDTO.setMaxSalary(35.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(true);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("dimitar.kolev");
        userDTO.setPassword("dimitarkolev");
        userDTO.setRepeatPassword("dimitarkolev");
        userDTO.setName("Dimitar");
        userDTO.setSurname("Kolev");
        userDTO.setEmail("dimitar.kolev@example.com");
        userDTO.setAddress("404 Not Found St");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(8);
        userEditDTO.setOffersChildCare(true);
        userEditDTO.setOffersElderCare(false);
        userEditDTO.setOffersPetCare(true);
        userEditDTO.setMinSalary(15.00);
        userEditDTO.setMaxSalary(25.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(false);
        userEditDTO.setNonSmoker(false);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("marija.dodevska");
        userDTO.setPassword("marijadodevska");
        userDTO.setRepeatPassword("marijadodevska");
        userDTO.setName("Marija");
        userDTO.setSurname("Dodevska");
        userDTO.setEmail("marija.dodevska@example.com");
        userDTO.setAddress("505 High St");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(9);
        userEditDTO.setOffersChildCare(true);
        userEditDTO.setOffersElderCare(false);
        userEditDTO.setOffersPetCare(false);
        userEditDTO.setMinSalary(50.00);
        userEditDTO.setMaxSalary(75.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(false);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(true);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("sanja.kutanovska");
        userDTO.setPassword("sanjakutanovska");
        userDTO.setRepeatPassword("sanjakutanovska");
        userDTO.setName("Sanja");
        userDTO.setSurname("Kutanovska");
        userDTO.setEmail("sanja.kutanovska@example.com");
        userDTO.setAddress("606 Low Blvd");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(7);
        userEditDTO.setOffersChildCare(false);
        userEditDTO.setOffersElderCare(true);
        userEditDTO.setOffersPetCare(false);
        userEditDTO.setMinSalary(5.00);
        userEditDTO.setMaxSalary(10.00);
        userEditDTO.setTrainedInFirstAid(false);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(false);
        userEditDTO.setHasCar(false);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        userDTO = new UserRegisterDTO();
        userDTO.setUsername("monika.spasikj");
        userDTO.setPassword("monikaspasikj");
        userDTO.setRepeatPassword("monikaspasikj");
        userDTO.setName("Monika");
        userDTO.setSurname("Spasikj");
        userDTO.setEmail("monika.spasikj@example.com");
        userDTO.setAddress("707 Edu Ave");
        userService.register(userDTO, Role.USER);
        user = userService.listAll().get(userService.listAll().size()-1);
        userEditDTO = UserEditDTO.of(user);
        userEditDTO.setGrade(8);
        userEditDTO.setOffersChildCare(false);
        userEditDTO.setOffersElderCare(false);
        userEditDTO.setOffersPetCare(true);
        userEditDTO.setMinSalary(20.00);
        userEditDTO.setMaxSalary(30.00);
        userEditDTO.setTrainedInFirstAid(true);
        userEditDTO.setComfortableWithPets(true);
        userEditDTO.setHighEducation(true);
        userEditDTO.setHasCar(true);
        userEditDTO.setNonSmoker(true);
        userService.edit(user.getId(), userEditDTO);

        //Categories
        categoryService.create("Childcare");
        categoryService.create("Eldercare");
        categoryService.create("Pet care");


        //Jobs
        /*
        JobCreateDTO createDTO = new JobCreateDTO();
        createDTO.setTitle("New job");
        createDTO.setDescription("Test job description");
        createDTO.setSalary(7650.00);
        createDTO.setLocation("Somewhere, everywhere");
        createDTO.setExperienceRequired(1);
        createDTO.setCategories(Arrays.asList(1L, 2L, 3L));
        createDTO.setPostedBy("admin");
        jobService.create(createDTO);
         */
    }

}
