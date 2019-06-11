package com.leiyide.config;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 
 * @Title:CustomCommentGenerator
 * @Description: 自定义comment生成器,将数据库表字段中的注释加入，并可以开启jpa注解
 * @Company: 智能科技
 * @author leiyide
 * @date 2019年5月20日 下午3:05:14
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

	private Properties properties;
	private Properties systemPro;
	private boolean suppressDate;
	private boolean suppressAllComments;
	private String currentDateStr;

	public CustomCommentGenerator() {
		super();
		properties = new Properties();
		systemPro = System.getProperties();
		suppressDate = false;
		suppressAllComments = false;
		currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}

	// ****默认情况下不添加任何文件级别的注释**/
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		return;
	}

	// ****添加适当的注释，以警告用户已生成元素，并且当它产生的时候**/
	public void addComment(XmlElement xmlElement) {
		return;
	}

	// ****默认情况下不添加文档级注释**/
	public void addRootComment(XmlElement rootElement) {
		return;
	}

	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
		suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
		suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	/**
	 * This method adds the custom javadoc tag for. You may do nothing if you do not
	 * wish to include the Javadoc tag - however, if you do not include the Javadoc
	 * tag then the Java merge capability of the eclipse plugin will break.
	 * 
	 * @param javaElement
	 *            the java element
	 */
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		javaElement.addJavaDocLine(" *");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		if (markAsDoNotDelete) {
			sb.append(" do_not_delete_during_merge");
		}
		String s = getDateString();
		if (s != null) {
			sb.append(' ');
			sb.append(s);
		}
		javaElement.addJavaDocLine(sb.toString());
	}

	/**
	 * This method returns a formated date string to include in the Javadoc tag and
	 * XML comments. You may return null if you do not want the date in these
	 * documentation elements.
	 * 
	 * @return a string representing the current timestamp, or null
	 */
	protected String getDateString() {
		String result = null;
		if (!suppressDate) {
			result = currentDateStr;
		}
		return result;
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" ");
		sb.append(getDateString());
		innerClass.addJavaDocLine(sb.toString());
		innerClass.addJavaDocLine(" */");
	}

	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerEnum.addJavaDocLine("/**");
		// addJavadocTag(innerEnum, false);
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerEnum.addJavaDocLine(sb.toString());
		innerEnum.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		field.addJavaDocLine(sb.toString());
		// addJavadocTag(field, false);
		field.addJavaDocLine(" */");
		// field.addAnnotation("@Size(min = 0, max = " +
		// introspectedColumn.getLength() + " , message =
		// \"长度必须在{min}和{max}之间\")");
		// field.addAnnotation("@NotNull"); if
		// (introspectedColumn.isStringColumn()) {
		// topLevelClass.addImportedType("javax.validation.constraints.Size");
		// field.addAnnotation("@Size(min = 0, max = " +
		// introspectedColumn.getLength() + " , message =
		// \"长度必须在{min}和{max}之间\")"); }
		
		List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
		for (IntrospectedColumn col : primaryKeyColumns) {
			if (col.getActualColumnName().equals(introspectedColumn.getActualColumnName())) {
				//field.addAnnotation("@Id");【关闭字段注解】
			}
		}
		//field.addAnnotation("@Column(name = \"" + introspectedColumn.getActualColumnName() + "\")");【关闭字段注解】
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		field.addJavaDocLine(sb.toString());
		field.addJavaDocLine(" */");
	}

	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		// method.addJavaDocLine("/**");
		// addJavadocTag(method, false);
		// method.addJavaDocLine(" */");
	}

	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		sb.setLength(0);
		sb.append(" * @return ");
		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		// addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		Parameter parm = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param ");
		sb.append(parm.getName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		// addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	@Deprecated
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

	}

	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//		topLevelClass.addImportedType("javax.persistence.Column");【关闭字段注解】
//		topLevelClass.addImportedType("javax.persistence.Id");
//		topLevelClass.addImportedType("javax.persistence.Table");
//		topLevelClass.addImportedType("org.apache.ibatis.type.Alias");

		if (suppressAllComments) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		topLevelClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(sb.toString());
		sb.setLength(0);
		sb.append(" * @author ");
		sb.append(systemPro.getProperty("user.name"));
		sb.append(" ");
		sb.append(currentDateStr);
		// addJavadocTag(innerClass, markAsDoNotDelete);【关闭字段注解】
//		topLevelClass.addJavaDocLine(" */");
//		topLevelClass.addAnnotation("@Table(name = \"" + introspectedTable.getFullyQualifiedTable() + "\")");
//		topLevelClass.addAnnotation("@Alias(\""
//				+ toLowerCaseFirstOne(introspectedTable.getTableConfiguration().getDomainObjectName()) + "\")");
		topLevelClass.addJavaDocLine("*/");
	}

	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
			Set<FullyQualifiedJavaType> imports) {
		System.out.println(method.getName());

	}

//	public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,【关闭字段注解】
//			IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
//		System.out.println(method.getName());
//
//	}

//	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,【关闭字段注解】
//			Set<FullyQualifiedJavaType> imports) {
//		System.out.println(field.getName());
//
//	}

//	public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,【关闭字段注解】
//			IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
//		System.out.println(field.getName());
//		field.addAnnotation("@Column(name = \"" + field.getName() + "\")");
//	}

//	public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,【关闭字段注解】
//			Set<FullyQualifiedJavaType> imports) {
//		System.out.println(innerClass);
//	}
}
