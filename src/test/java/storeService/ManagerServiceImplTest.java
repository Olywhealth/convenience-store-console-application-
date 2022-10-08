package storeService;

import org.junit.jupiter.api.Test;
import org.ola.domain.Staff;
import org.ola.domain.enums.GENDER;
import org.ola.domain.enums.POSITION;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerServiceImplTest {

    @Test
    void shouldHireCashier() {
        ManagerServiceImpl managerService = new ManagerServiceImpl();
        Staff cashier = new Staff("Emeka", GENDER.MALE, "0706975","Ajegunle", 010, POSITION.CASHIER, 2);
        Staff manager = new Staff("Obinna", GENDER.MALE,"0707564","Ajason",001,01,POSITION.MANAGER);
        String actual = managerService.hireACashier(manager,cashier);
        String expected = "Congrats Emeka you are welcome to our store";
        assertEquals(expected, actual);
    }
    @Test
    void shouldNotHireCashier() {
        ManagerServiceImpl managerService = new ManagerServiceImpl();
        Staff cashier = new Staff("Emeka", GENDER.MALE, "0706975","Ajegunle", 010, POSITION.CASHIER, 2);
        Staff manager = new Staff("Obinna", GENDER.MALE,"0707564","Ajason",001,01,POSITION.MANAGER);
        String actual = managerService.hireACashier(manager,cashier);
        String expected = "oops!!, Only managers are allowed to hire";
        assertEquals(expected, actual);
    }
}