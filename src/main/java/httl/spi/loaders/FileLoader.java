/*
 * Copyright 2011-2013 HTTL Team.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package httl.spi.loaders;

import httl.Resource;
import httl.spi.Loader;
import httl.spi.loaders.resources.FileResource;
import httl.internal.util.UrlUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * FileLoader. (SPI, Singleton, ThreadSafe)
 * 
 * @see httl.spi.engines.DefaultEngine#setLoader(Loader)
 * 
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public class FileLoader extends AbstractLoader {

	public List<String> doList(String directory, String suffix) throws IOException {
		File file = new File(directory);
		return UrlUtils.listFile(file, suffix);
	}
	
	protected Resource doLoad(String name, Locale locale, String encoding, String path) throws IOException {
		return new FileResource(getEngine(), name, locale, encoding, path);
	}

	public boolean doExists(String name, Locale locale, String path) throws Exception {
		return new File(path).exists();
	}

}
