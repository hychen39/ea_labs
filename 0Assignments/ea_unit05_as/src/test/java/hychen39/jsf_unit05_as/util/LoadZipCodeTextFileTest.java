package hychen39.jsf_unit05_as.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hychen39@gm.cyut.edu.tw
 * @since 4/18/2020
 */
class LoadZipCodeTextFileTest {

    @org.junit.jupiter.api.Test
    void load() {
        System.out.println(System.getProperty("user.dir"));
        Path zipCodeTextFile = Paths.get("./taiwan_zip_codes.txt");
        LoadZipCodeTextFile loadZipCodeTextFile = new LoadZipCodeTextFile();
        loadZipCodeTextFile.load(zipCodeTextFile);
        Map<String, Map<String, Integer>> zipCodes = loadZipCodeTextFile.getZipCodes();
        assertNotEquals(0, zipCodes.size());

        int zipCode1 = zipCodes.get("臺北市").get("中正區");
        assertEquals(100, zipCode1);

        int zipCode2 = zipCodes.get("宜蘭縣").get("員山");
        assertEquals(264, zipCode2);
    }
}
