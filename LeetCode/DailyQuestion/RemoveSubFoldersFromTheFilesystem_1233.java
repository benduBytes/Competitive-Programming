package DailyQuestion;
import java.util.*;

//Time Complexity: O(NLogN)
//Space Complexity: O(N)

public class RemoveSubFoldersFromTheFilesystem_1233 {
	public List<String> removeSubfolders(String[] folder) {
		// In ASCII, '/' is before 'a': e.g., '/a', '/a/b', '/aa'
		// After sorting the folder array, we only need to consider if the current folder is a subfolder of the previous one or not.
		Arrays.sort(folder);
		
		List<String> result = new ArrayList<>();
		
		for (String dir : folder)
			if (result.isEmpty() || !dir.startsWith(result.get(result.size()-1) + "/"))
				result.add(dir);
				
		return result;
	}
}
/*
Example 1:
Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.

Example 2:
Input: folder = ["/a","/a/b/c","/a/b/d"]
Output: ["/a"]
Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".

Example 3:
Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
Output: ["/a/b/c","/a/b/ca","/a/b/d"]
*/