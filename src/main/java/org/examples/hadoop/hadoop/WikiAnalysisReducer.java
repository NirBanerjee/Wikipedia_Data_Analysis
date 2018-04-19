/**
 * @author nirmoho-Mac
 *
 */
package org.examples.hadoop.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WikiAnalysisReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

}
