package com.deleidos.analytics.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 * File utilities.
 * 
 * @author vernona
 */
public class FileUtil {

	/**
	 * Get all files under a base directory with a particular extension. If recursive is true, sub-directories will be
	 * searched.
	 * 
	 * @param baseDir
	 * @param extension
	 * @param recursive
	 * @return
	 */
	public static Collection<File> getFilesByExtension(String baseDir, String extension, boolean recursive) {
		return FileUtils.listFiles(new File(baseDir), new SuffixFileFilter(extension),
				recursive ? TrueFileFilter.INSTANCE : null);
	}

	/**
	 * Get the contents of a file as a string.
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String getFileContentsAsString(File file) throws IOException {
		return FileUtils.readFileToString(file);
	}

	/**
	 * Get the file name without the extension. Everything after the first dot is excluded.
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileNameWithoutExtension(File file) {
		return file.getName().substring(0, file.getName().indexOf("."));
	}
}
