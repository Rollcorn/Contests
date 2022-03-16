/*******************************************************************************
 * 
 * You are a product manager and currently leading a team to develop a new 
 * product. Unfortunately, the latest version of your product fails the quality 
 * check. Since each version is developed based on the previous version, all 
 * the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the 
 * first bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether 
 * version is bad. Implement a function to find the first bad version. You 
 * should minimize the number of calls to the API.
 * 
 */

/*
 *   The isBadVersion API is defined in the parent class VersionControl.
 *   boolean isBadVersion(int version); 
 */

 /*
                      return
                           ||
                           \/
     false  false  false  true  true  true 
  */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int firstVersion = 0;
        int lastVersion = n;
        int middleArrayIndex = n / 2;

        while( (lastVersion - firstVersion) != 1 ) {
            
            if ( isBadVersion(middleArrayIndex) ) {
                lastVersion = middleArrayIndex;
            } else {
                firstVersion = middleArrayIndex;
            }

            middleArrayIndex = firstVersion + (lastVersion - firstVersion) / 2;
        }            

        return lastVersion;
    }
}
