package bj.anagonou.bingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class HelloWorldTest {


    @Test
    public void testImmutableCollections() {

        List<String> fruits = List.of("Mangosteen", "Durian fruit", "Longan");

        assertThrows(UnsupportedOperationException.class, () -> {
            fruits.add("Mango");
            fruits.remove(1);
        });

        assertEquals(3, fruits.size());

    }

    @Test
    public void getBingoSequenceTest(){
        String input = """
                83,69,34,46,30,23,19,75,22,37,89,78,32,39,11,44,95,43,26,48,84,53,94,88,18,40,62,35,27,42,15,2,91,20,4,64,99,71,54,97,52,36,28,7,74,45,70,86,98,1,61,50,68,6,77,8,57,47,51,72,65,3,49,24,79,13,17,92,41,80,63,67,82,90,55,0,10,93,38,21,59,73,33,31,9,76,5,66,16,58,85,87,12,29,25,14,96,56,60,81
                                
                68 73 98 51 49
                82 56 87 64  8
                46  7 21 38 30
                66  5 86 97 74
                60 63 76 55 39
                                
                92 20 87 77 52
                72 29 81 24 64
                26 16 19 79 68
                 8 53 90 14 74
                28 89 78 54 15
                """;
        assertEquals(List.of(83,69,34,46,30,23,19,75,22,37,89,78,32,39,11,44,95,43,26,48,84,53,94,88,18,40,62,35,27,42,15,2,91,20,4,64,99,71,54,97,52,36,28,7,74,45,70,86,98,1,61,50,68,6,77,8,57,47,51,72,65,3,49,24,79,13,17,92,41,80,63,67,82,90,55,0,10,93,38,21,59,73,33,31,9,76,5,66,16,58,85,87,12,29,25,14,96,56,60,81), HelloWorld.getBingoSequence(input));
    }
}
