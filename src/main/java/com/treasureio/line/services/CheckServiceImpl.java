package com.treasureio.line.services;

import com.treasureio.line.exception.CheckNotFoundException;
import com.treasureio.line.models.Check;
import com.treasureio.line.repositories.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckRepository checkRepository;

    @Override
    public Check saveCheck(Check check) {

        String string1 = check.getStudent1Text();
        String string2 = check.getStudent2Text();

        Long l2=Long.valueOf(pecentageOfTextMatch(string1, string2));

        check.setCheckScore(l2);
        return checkRepository.save(check);
    }

    @Override
    public List<Check> fetchCheckList() {
        return checkRepository.findAll();
    }

    @Override
    public Check fetchCheckById(Long checkId) throws CheckNotFoundException {
        Optional<Check> check = checkRepository.findById(checkId);

        if(!check.isPresent()) {
            throw new CheckNotFoundException("Check Not Available");
        }
        return check.get();
    }



    static int compute_Levenshtein_distanceDP(String str1,
                                              String str2)
    {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++)
        {
            for (int j = 0; j <= str2.length(); j++) {

                // If str1 is empty, all characters of
                // str2 are inserted into str1, which is of
                // the only possible method of conversion
                // with minimum operations.
                if (i == 0) {
                    dp[i][j] = j;
                }

                // If str2 is empty, all characters of str1
                // are removed, which is the only possible
                //  method of conversion with minimum
                //  operations.
                else if (j == 0) {
                    dp[i][j] = i;
                }

                else {
                    // find the minimum among three
                    // operations below


                    dp[i][j] = minm_edits(dp[i - 1][j - 1]
                                    + NumOfReplacement(str1.charAt(i - 1),str2.charAt(j - 1)), // replace
                            dp[i - 1][j] + 1, // delete
                            dp[i][j - 1] + 1); // insert
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    // check for distinct characters between strings
    static int NumOfReplacement(char c1, char c2)
    {
        return c1 == c2 ? 0 : 1;
    }

    // receives the count of different operations performed and returns the minimum value among them.

    static int minm_edits(int... nums)
    {

        return Arrays.stream(nums).min().orElse(
                Integer.MAX_VALUE);
    }

    public static int pecentageOfTextMatch(String s0, String s1) {
        int percentage = 0;
        // Trim and remove duplicate spaces
        s0 = s0.trim().replaceAll("\\s+", " ");
        s1 = s1.trim().replaceAll("\\s+", " ");
        percentage=(int) (100 - (float) compute_Levenshtein_distanceDP(s0, s1) * 100 / (float) (s0.length() + s1.length()));
        return percentage;
    }


}
