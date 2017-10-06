package com.ingester.objectDefinition;

import org.junit.Test;

import com.ingester.TestUtils;

import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Created by ICorda on 02/08/2016.
 */
public class TestBusStop {

    //Given
    final BusStop busRoute = new BusStop();

    @Test
    public void testSetCode_setsProperly() throws NoSuchFieldException, IllegalAccessException {

        //When
        busRoute.setCode("anotherCode");

        //Then
        final Field fieldCode = busRoute.getClass().getDeclaredField("code");
        fieldCode.setAccessible(true);
        assertEquals("The fields do not match ", fieldCode.get(busRoute), "anotherCode");
    }

    @Test
    public void testGetCode_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //Given
        final Field fieldCode = busRoute.getClass().getDeclaredField("code");
        fieldCode.setAccessible(true);
        fieldCode.set(busRoute, "retrievedCode");

        //When
        final String resultCode = busRoute.getCode();

        //Then
        assertEquals("The field code was not properly retrieved", resultCode, "retrievedCode");

    }

    @Test
    public void testSetName_setsProperly() throws NoSuchFieldException, IllegalAccessException {

        //When
        busRoute.setName("anotherName");

        //Then
        final Field fieldName = busRoute.getClass().getDeclaredField("name");
        fieldName.setAccessible(true);
        assertEquals("The fields do not match ", fieldName.get(busRoute), "anotherName");
    }

    @Test
    public void testGetName_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //Given
        final Field fieldName = busRoute.getClass().getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(busRoute, "retrievedName");

        //When
        final String resultName = busRoute.getName();

        //Then
        assertEquals("The field name was not properly retrieved", resultName, "retrievedName");

    }

    @Test
    public void testSetLatitude_setsProperly() throws NoSuchFieldException, IllegalAccessException {

        //When
        busRoute.setLatitude("anotherLatitude");

        //Then
        final Field fieldLatitude = busRoute.getClass().getDeclaredField("latitude");
        fieldLatitude.setAccessible(true);
        assertEquals("The fields do not match ", fieldLatitude.get(busRoute), "anotherLatitude");
    }

    @Test
    public void testGetLatitude_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //Given
        final Field fieldLatitude = busRoute.getClass().getDeclaredField("latitude");
        fieldLatitude.setAccessible(true);
        fieldLatitude.set(busRoute, "retrievedLatitude");

        //When
        final String resultLatitude = busRoute.getLatitude();

        //Then
        assertEquals("The field latitude was not properly retrieved", resultLatitude, "retrievedLatitude");

    }

    @Test
    public void testSetLongitude_setsProperly() throws NoSuchFieldException, IllegalAccessException {

        //When
        busRoute.setLongitude("anotherLongitude");

        //Then
        final Field fieldLongitude = busRoute.getClass().getDeclaredField("longitude");
        fieldLongitude.setAccessible(true);
        assertEquals("The fields do not match ", fieldLongitude.get(busRoute), "anotherLongitude");
    }

    @Test
    public void testGetLongitude_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //Given
        final Field fieldLongitude = busRoute.getClass().getDeclaredField("longitude");
        fieldLongitude.setAccessible(true);
        fieldLongitude.set(busRoute, "retrievedLongitude");

        //When
        final String resultLongitude = busRoute.getLongitude();

        //Then
        assertEquals("The field longitude was not properly retrieved", resultLongitude, "retrievedLongitude");

    }

    @Test
    public void testToStringReturnsTrue() throws NoSuchFieldException, IllegalAccessException {
        String expectedToString = TestUtils.getToStringBusStop("myCode", "myName", "myLatitude", "myLongitude");
        String setFields = setAllFields("myCode", "myName", "myLatitude", "myLongitude").toString();
        assertEquals(busRoute.toString(), expectedToString);
    }

    @Test
    public void testToStringReturnsFalseIfNullValue() throws NoSuchFieldException, IllegalAccessException {
        String expectedToString = TestUtils.getToStringBusStop(null, "myName", "myLatitude", "myLongitude");
        String setFields = setAllFields("myCode", "myName", "myLatitude", "myLongitude").toString();
        assertNotSame(busRoute.toString(), expectedToString);
    }

    @Test
    public void testToStringReturnsFalseIfEmptyValue() throws NoSuchFieldException, IllegalAccessException {
        String expectedToString = TestUtils.getToStringBusStop("myCode", "myName", "myLatitude", "myLongitude");
        String setFields = setAllFields("", "myName", "myLatitude", "myLongitude").toString();
        assertNotSame(busRoute.toString(), expectedToString);
    }


    //HELPER METHODS

    //To be moved to the TestUtils class that includes a number of utils or generic helper methods for our Vo tests
    private Field[] setAllFields(String code, String name, String latitude, String longitude) throws NoSuchFieldException, IllegalAccessException {

        final Field fieldCode = busRoute.getClass().getDeclaredField("code");
        fieldCode.setAccessible(true);
        fieldCode.set(busRoute, code);

        final Field fieldName = busRoute.getClass().getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(busRoute, name);

        final Field fieldLatitude = busRoute.getClass().getDeclaredField("latitude");
        fieldLatitude.setAccessible(true);
        fieldLatitude.set(busRoute, latitude);

        final Field fieldLongitude = busRoute.getClass().getDeclaredField("longitude");
        fieldLongitude.setAccessible(true);
        fieldLongitude.set(busRoute, longitude);

        return new Field[3];
    }
}
