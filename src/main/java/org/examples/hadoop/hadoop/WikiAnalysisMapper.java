/**
 * @author nirmoho-Mac
 *
 */
package org.examples.hadoop.hadoop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WikiAnalysisMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final List<String> blackList = new ArrayList<String>(Arrays.asList("draft_talk:", "draft:", "gadget_talk:", "gadget:", "gadget_definition_talk:",
            "gadget_definition:", "talk:", "user_talk:", "user:", "wikipedia_talk:",
            "wikipedia:", "file_talk:", "file:", "mediawiki_talk:", "mediawiki:",
            "education_program_talk:", "education_program:", "timedtext_talk:", "timedtext:",
            "book:", "book_talk:", "portal:", "portal_talk:", "template_talk:", "template:",
            "help_talk:", "help:", "category_talk:", "category:", "module_talk:", "special:",
            "module:", "media:"));
    
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException  {
        String line = value.toString();
        
        String[] lineParts = line.split(" ");
        if (lineParts.length != 4)  {
            return;
        }
        lineParts[1] = Decode.decode(lineParts[1]);
        if (!"en".equals(lineParts[0]) && !"en.m".equals(lineParts[0]))  {
            return;
        }
        if (blackList.contains(lineParts[1]))   {
            return;
        }
        
        String mapKey = lineParts[1];
        word.set(mapKey);
        context.write(word, one);
    }
}
