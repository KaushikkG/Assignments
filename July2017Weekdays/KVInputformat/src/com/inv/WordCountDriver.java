package com.inv;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;


public class WordCountDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf=new Configuration();
		conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", "|");
		Job job=Job.getInstance(conf, "Sample Word Count");
		
		job.setJarByClass(WordCountDriver.class); // entry point
		job.setMapperClass(WordCountMapper.class);
		//job.setReducerClass(WordCountReducer.class);
	
		job.setNumReduceTasks(0);
		
		//job.setCombinerClass(WordCountReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
			
	job.setInputFormatClass(KeyValueTextInputFormat.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		

		
		boolean status=job.waitForCompletion(true);
		int result=status?0:1;
		System.exit(result);
		//System.exit(job.waitForCompletion(true)?0:1);
	}

}
