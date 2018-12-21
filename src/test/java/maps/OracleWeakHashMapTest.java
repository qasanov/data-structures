package maps;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class OracleWeakHashMapTest {

    @Test
    public void createMapsWithGCCalled() {
        String weakMapKey = new String("someWeakKey");
        Integer weakMapValue = 15;

        String normalMapKey = new String("someNormalKey");
        Integer normalMapValue = 13;

        Map<String,Integer> wMap = new WeakHashMap<>();
        wMap.put(weakMapKey,weakMapValue);

        Map<String,Integer> nMap = new HashMap<>();
        nMap.put(normalMapKey,normalMapValue);

        assertThat(wMap.get("someWeakKey")).isEqualTo(weakMapValue);
        assertThat(nMap.get("someNormalKey")).isEqualTo(normalMapValue);

        weakMapKey = null;
        normalMapKey = null;
        System.gc();

        assertThat(wMap.get("someWeakKey")).isNull();
        assertThat(nMap.get("someNormalKey")).isEqualTo(normalMapValue);
    }

    @Test
    public void createMapsWithoutGCCalled() {
        String weakMapKey = new String("someWeakKey");
        Integer weakMapValue = 15;

        String normalMapKey = new String("someNormalKey");
        Integer normalMapValue = 13;

        Map<String,Integer> wMap = new WeakHashMap<>();
        wMap.put(weakMapKey,weakMapValue);

        Map<String,Integer> nMap = new HashMap<>();
        nMap.put(normalMapKey,normalMapValue);

        assertThat(wMap.get("someWeakKey")).isEqualTo(weakMapValue);
        assertThat(nMap.get("someNormalKey")).isEqualTo(normalMapValue);

        weakMapKey = null;
        normalMapKey = null;

        assertThat(wMap.get("someWeakKey")).isEqualTo(weakMapValue);
        assertThat(nMap.get("someNormalKey")).isEqualTo(normalMapValue);
    }
}
