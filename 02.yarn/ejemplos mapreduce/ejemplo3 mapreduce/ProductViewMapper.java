package ProductView;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class ProductViewMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        String valueString = value.toString();
        String[] visitData = valueString.split(",");
        int personID = Integer.parseInt(visitData[0]);
        String productType = visitData[2];
        output.collect(new Text(productType), new IntWritable(personID));
    }
}