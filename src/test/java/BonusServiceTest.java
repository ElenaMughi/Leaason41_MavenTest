import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

//    @org.junit.jupiter.api.Test - можно сократить до:
    @Test  //меньше лимита для зарегистрированного
    void shouldCalculateWhenRegisteredAndBonusAnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1000_60;
        boolean registred = true;
        long expected = 30;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //больше лимита для зарегистрированного
    void shouldCalculateWhenRegisteredAndBonusMoreThanLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registred = true;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //меньше лимита для незарегистрированного
    void shouldCalculateWhenUnRegisteredAndBonusAnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1_000_60;
        boolean registred = false;
        long expected = 10;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //больше лимита для незарегистрированного
    void shouldCalculateWhenUnRegisteredAndBonusMoreThanLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registred = false;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //отработка нуля
    void shouldCalculateWhenRegisteredAndBonusAndNull() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 0;
        boolean registred = true;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //отработка нуля
    void shouldCalculateWhenUnRegisteredAndBonusAndNull() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 0;
        boolean registred = false;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }
    @Test  //граница для зарегистрированного юзера
    void shouldCalculateWhenRegisteredAndBonusAnderLimitAndValueBoundary() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 16_666_66;
        boolean registred = true;
        long expected = 499;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //граница для зарегистрированного юзера
    void shouldCalculateWhenRegisteredAndBonusMoreThanLimitAndValueBoundary() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 16_666_67;
        boolean registred = true;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //граница для незарегистрированного юзера
    void shouldCalculateWhenUnRegisteredAndBonusAnderLimitAndValueBoundary() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 49_999_99;
        boolean registred = false;
        long expected = 499;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //граница для незарегистрированного юзера
    void shouldCalculateWhenUnRegisteredAndBonusMoreThanLimitAndValueBoundary() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 50_000_00;
        boolean registred = false;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //первая копеечка для зарегистрированного
    void shouldCalculateWhenRegisteredAndBonusAnderLimitAndFirstBonus() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 33_33;
        boolean registred = true;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //первая копеечка для зарегистрированного
    void shouldCalculateWhenRegisteredAndBonusMoreThanLimitAndFirstBonus() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 33_34;
        boolean registred = true;
        long expected = 1;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //первая копеечка для незарегистрированного
    void shouldCalculateWhenUnRegisteredAndBonusAnderLimitAndFirstBonus() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 99_99;
        boolean registred = false;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }

    @Test  //первая копеечка для незарегистрированного
    void shouldCalculateWhenUnRegisteredAndBonusMoreThanLimitAndFirstBonus() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 100_00;
        boolean registred = false;
        long expected = 1;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registred);

        assertEquals(expected, actual);
    }
}