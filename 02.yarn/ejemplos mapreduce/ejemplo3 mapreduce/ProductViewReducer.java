package ProductView;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class ProductViewReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text> {
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        Set<Integer> uniquePersonIDs = new HashSet<>();
        while (values.hasNext()) {
            uniquePersonIDs.add(values.next().get());
        }
        output.collect(key, new Text(uniquePersonIDs.toString()));
    }
}