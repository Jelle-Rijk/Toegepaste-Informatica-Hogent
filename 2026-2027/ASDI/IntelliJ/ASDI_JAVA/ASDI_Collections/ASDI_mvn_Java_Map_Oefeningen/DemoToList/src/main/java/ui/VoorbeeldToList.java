package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VoorbeeldToList {

	public void main()
	{
		List<Character> lijst = List.of('n', 'g', 'P', 'a', 'p');
		
		List<Character> lijst2 = 
				lijst.stream().filter(c -> Character.isLowerCase(c)).
				collect(Collectors.toList());
		
		lijst2.add('b');
		lijst2.remove(0);
		lijst2.sort(null);
		IO.println(lijst2);
		
		List<Character> lijst3 = lijst.stream().
				filter(c -> Character.isLowerCase(c)).toList();
		try
		{
			lijst3.add('b');
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			lijst3.remove(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			lijst3.sort(null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
