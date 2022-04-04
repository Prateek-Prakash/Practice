import java.util.*;

class CompartmentCount {
    public static void main(String[] args) {
        runTestsA();
        runTestsB();
    }

    private static Integer calculateCount(String stringPattern, Integer startIdx, Integer endIdx) {
        // Debug Printing
        // System.out.println("START: " + startIdx);
        // System.out.println("END: " + endIdx);
        // System.out.println();

        char[] charPattern = stringPattern.toCharArray();

        List<Integer> countList = new ArrayList<>();

        Integer firstIdx = -1;
        Integer lastIdx = -1;
        Integer matchCount = 0;
        Integer dividerCount = 0;

        // Generate Count List
        for (int i = 0; i < charPattern.length; i++) {
            if (charPattern[i] == '|') {
                if (firstIdx == -1) {
                    firstIdx = i;
                }
                lastIdx = i;
                countList.add(matchCount);
                dividerCount++;
            } else {
                countList.add(++matchCount);
            }
        }

        // Edge Case
        if (dividerCount < 2) {
            return 0;
        }

        // Debug Printing
        // System.out.println("FIRST: " + firstIdx);
        // System.out.println("LAST: " + lastIdx);
        // System.out.println();

        // Edge Cases
        if (endIdx < firstIdx) {
            return 0;
        }
        if (startIdx > lastIdx) {
            return 0;
        }

        // Check Indexes
        if (startIdx < firstIdx) {
            startIdx = firstIdx;
        }
        if (endIdx > lastIdx) {
            endIdx = lastIdx;
        }

        // Check Start + End == '|'
        while (charPattern[startIdx] != '|') {
            startIdx++;
        }
        while (charPattern[endIdx] != '|') {
            endIdx--;
        }

        // Debug Printing
        // System.out.println("FIRST: " + firstIdx);
        // System.out.println("LAST: " + lastIdx);
        // System.out.println();

        // Debug Printing
        // System.out.println("START: " + startIdx);
        // System.out.println("END: " + endIdx);
        // System.out.println();

        // Debug Printing
        // for (int i = 0; i < charPattern.length; i++) {
        // System.out.print(charPattern[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < countList.size(); i++) {
        // System.out.print(countList.get(i) + " ");
        // }
        // System.out.println("\n");

        return countList.get(endIdx) - countList.get(startIdx);
    }

    private static void runTestsA() {
        System.out.println("Running Pattern-A Tests...");

        String stringPattern = "******|**|*|****";

        List<Integer> startIndices = Arrays.asList(0, 0, 12, 5, 0, 9, 0);
        List<Integer> endIndicies = Arrays.asList(10, 4, 14, 7, 1, 11, 15);
        List<Integer> expectedCounts = Arrays.asList(2, 0, 0, 0, 0, 1, 3);

        for (int i = 0; i < startIndices.size(); i++) {
            Integer startIdx = startIndices.get(i);
            Integer endIdx = endIndicies.get(i);
            Integer expectedCount = expectedCounts.get(i);
            if (calculateCount(stringPattern, startIdx, endIdx) != expectedCount) {
                System.out.println("\u2717 FAILED [" + startIdx + "," + endIdx + "]");
            } else {
                System.out.println("\u2713 PASSED [" + startIdx + "," + endIdx + "]");
            }
        }
    }

    private static void runTestsB() {
        System.out.println("Running Pattern-B Tests...");

        String stringPattern = "******|**";

        List<Integer> startIndices = Arrays.asList(0, 5);
        List<Integer> endIndicies = Arrays.asList(8, 7);
        List<Integer> expectedCounts = Arrays.asList(0, 0);

        for (int i = 0; i < startIndices.size(); i++) {
            Integer startIdx = startIndices.get(i);
            Integer endIdx = endIndicies.get(i);
            Integer expectedCount = expectedCounts.get(i);
            if (calculateCount(stringPattern, startIdx, endIdx) != expectedCount) {
                System.out.println("\u2717 FAILED [" + startIdx + "," + endIdx + "]");
            } else {
                System.out.println("\u2713 PASSED [" + startIdx + "," + endIdx + "]");
            }
        }
    }
}
