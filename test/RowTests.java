import com.TTT.TTTLine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RowTests {

    private List<Integer> spaces;

    @Before
    public void setUp() {
        spaces = new ArrayList<>();
    }

    @Test
    public void canReturnTTTRowSize() {
       spaces.add(1);
       spaces.add(1);
       spaces.add(1);

        TTTLine row = new TTTLine(spaces);

        assertEquals(3, row.size());
    }

    @Test
    public void canRetriveSpaceIndexOnBoard() {
        spaces.add(5);

        TTTLine row = new TTTLine(spaces);

        assertEquals(5, row.getSpaceIndex(0));
    }
}
