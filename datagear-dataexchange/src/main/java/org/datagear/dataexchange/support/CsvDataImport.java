/*
 * Copyright (c) 2018 datagear.org. All Rights Reserved.
 */

package org.datagear.dataexchange.support;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.datagear.dataexchange.ConnectionFactory;
import org.datagear.dataexchange.DataFormat;
import org.datagear.dataexchange.ResourceFactory;
import org.datagear.dataexchange.TableTextDataImport;
import org.datagear.dataexchange.TextDataImportListener;
import org.datagear.dataexchange.TextDataImportOption;

/**
 * CSV导入。
 * 
 * @author datagear@163.com
 *
 */
public class CsvDataImport extends TableTextDataImport
{
	private TextDataImportOption importOption;
	/** CSV输入流 */
	private ResourceFactory<Reader> readerFactory;

	private TextDataImportListener listener;

	public CsvDataImport()
	{
		super();
	}

	public CsvDataImport(ConnectionFactory connectionFactory, DataFormat dataFormat, TextDataImportOption importOption,
			String table, ResourceFactory<Reader> readerFactory)
	{
		super(connectionFactory, dataFormat, table);
		this.importOption = importOption;
		this.readerFactory = readerFactory;
	}

	@Override
	public TextDataImportOption getImportOption()
	{
		return importOption;
	}

	public void setImportOption(TextDataImportOption importOption)
	{
		this.importOption = importOption;
	}

	public ResourceFactory<Reader> getReaderFactory()
	{
		return readerFactory;
	}

	public void setReaderFactory(ResourceFactory<Reader> readerFactory)
	{
		this.readerFactory = readerFactory;
	}

	@Override
	public TextDataImportListener getListener()
	{
		return listener;
	}

	public void setListener(TextDataImportListener listener)
	{
		this.listener = listener;
	}

	/**
	 * 构建{@linkplain CsvDataImport}列表。
	 * 
	 * @param connectionFactory
	 * @param dataFormat
	 * @param importOption
	 * @param tables
	 * @param readerFactories
	 * @return
	 */
	public static List<CsvDataImport> valuesOf(ConnectionFactory connectionFactory, DataFormat dataFormat,
			TextDataImportOption importOption, List<String> tables,
			List<? extends ResourceFactory<Reader>> readerFactories)
	{
		List<CsvDataImport> csvDataImports = new ArrayList<CsvDataImport>(tables.size());

		for (int i = 0; i < tables.size(); i++)
		{
			CsvDataImport csvDataImport = new CsvDataImport(connectionFactory, dataFormat, importOption, tables.get(i),
					readerFactories.get(i));

			csvDataImports.add(csvDataImport);
		}

		return csvDataImports;
	}
}
