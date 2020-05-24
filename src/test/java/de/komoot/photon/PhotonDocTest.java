package de.komoot.photon;

import java.util.HashMap;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class PhotonDocTest {

    @Test
    public void testCompleteAddressOverwritesStreet() {
        HashMap<String, String> address = new HashMap<>();
        address.put("street", "test street");
        PhotonDoc doc = createPhotonDocWithAddress(address);
        
        HashMap<String, String> streetNames = new HashMap<>();
        streetNames.put("name", "parent place street");
        doc.setStreet(streetNames);
        
        doc.completeFromAddress();
        Assert.assertThat(doc.getStreet().get("name"), IsEqual.equalTo("test street"));    
    }

    @Test
    public void testCompleteAddressCreatesStreetIfNonExistantBefore() {
        HashMap<String, String> address = new HashMap<>();
        address.put("street", "test street");
        PhotonDoc doc = createPhotonDocWithAddress(address);
        
        doc.completeFromAddress();
        Assert.assertThat(doc.getStreet().get("name"), IsEqual.equalTo("test street"));    
    }

    private PhotonDoc createPhotonDocWithAddress(HashMap<String, String> address) {
        return new PhotonDoc(1, "W", 2, "highway", "residential", null, "4", address, null, null, 0, 30, null, null, 0, 30);
    }

}
