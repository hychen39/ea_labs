package hychen39.jsf_unit05_as.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Hashtable;
import java.util.Map;

/**
 * Load the zip codes from a text file into a Map
 * @author hychen39@gm.cyut.edu.tw
 * @since 4/18/2020
 */
public class LoadZipCodeTextFile {
    private Map<String, Map<String, Integer>> zipMap;
    private Path zipTextFile;

    
    /**
     * Load zip codes from file 
     * @param zipTextFile 文字檔案的路徑
     */
    public void load(Path zipTextFile){
        if (Files.notExists(zipTextFile))
            System.out.printf("The target file is not exist: %s ", zipTextFile.toString());
        zipMap = new Hashtable<>();
        // get buffer stream
        try (BufferedReader br = Files.newBufferedReader(zipTextFile)){
            String line = "";
            int counter = 0;
            while ( (line = br.readLine()) != null){
                addToZipMap(line);
                counter++;
            }
            System.out.printf("Number of lines been read: %s", counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add the a raw data to the zip map.
     * row data format: county(縣市) area(區域) zip_code. For example:  <code> 臺北市 中正區	100 </code>
     *
     * @param rawData row data format <code> 臺北市 中正區	100 </code>
     */
    public void addToZipMap(String rawData){
        // split raw data
        String [] fields = rawData.split("\\s+");
        if (fields.length != 3) {
            System.out.println("Cannot split the raw data: " + rawData);
            return;
        }

        // get county, area, and zip_code
        String county = fields[0];
        String area = fields[1];
        Integer zip_code = Integer.valueOf(fields[2]);

        // get the areas for a county
        if (zipMap.containsKey(county)){
            zipMap.get(county).put(area, zip_code);
        } else {
            Map<String, Integer> area_zipCode = new Hashtable<>();
            area_zipCode.put(area, zip_code);
            zipMap.put(county, area_zipCode);
        }
    }

    public Map<String,Map<String,Integer>> getZipCodes() {
        return this.zipMap;
    }
}
