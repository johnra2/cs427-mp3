package WhiteBox;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IpValidatorTest {

    @Test
    public void tooShortTest() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("Neither", tool.validIPAddress("0"));
    }

    @Test
    public void startsWithInvalidCharacterTest() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("Neither", tool.validIPAddress(".1234567"));
        assertEquals("Neither", tool.validIPAddress(":1234567890123456"));
    }

    @Test
    public void endsWithInvalidCharacterTest() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("Neither", tool.validIPAddress("1234567."));
        assertEquals("Neither", tool.validIPAddress("1234567890123456:"));
    }

    @Test
    public void invalidTokenCountTest() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("Neither", tool.validIPAddress("1.2.3.4.5"));
        assertEquals("Neither", tool.validIPAddress("1:2:3:4:5:6:7:8:9"));
    }

    @Test
    public void IPv4BadInputs() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("Neither", tool.validIPAddress("012.2.3.4"));
        assertEquals("Neither", tool.validIPAddress("-0.2.3.4"));
        assertEquals("Neither", tool.validIPAddress("-1.2.3.4"));
        assertEquals("Neither", tool.validIPAddress("256.2.3.4"));
        assertEquals("Neither", tool.validIPAddress("a.2.3.4"));
    }

    @Test
    public void IPv6BadInputs() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("Neither", tool.validIPAddress("12345:2:3:4:5:6:7:8"));
        assertEquals("Neither", tool.validIPAddress("1:::::::200000000"));
        assertEquals("Neither", tool.validIPAddress("(:2:3:4:5:6:7:8"));
        assertEquals("Neither", tool.validIPAddress("q:2:3:4:5:6:7:8"));
    }

    @Test
    public void validIPv4() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("IPv4", tool.validIPAddress("1.2.3.4"));
        assertEquals("IPv4", tool.validIPAddress("0.2.3.4"));
    }

    @Test
    public void validIPv6() {
        IpValidator tool = new IpValidatorImpl();
        assertEquals("IPv6", tool.validIPAddress("1:a:A:C:D5:d6:b7:e8"));
    }


    // @TODO: Create more tests
}
