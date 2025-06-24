"#PDF_Maker" 

O código tem como objetivo atuar como gerador de PDF apartir de um código HTML

1. Dependências

No arquivo pom.xml, deve ser adicionado:

```
<properties>
    <itext.pdfhtml.version>6.1.0</itext.pdfhtml.version>
    <itext.version>9.1.0</itext.version>
</properties>
<dependencies>
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>html2pdf</artifactId>
    <version>${itext.pdfhtml.version}</version>
  </dependency>
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>pdfua</artifactId>
    <version>${itext.version}</version>
  </dependency>
</dependencies>
<repositories>
    <repository>
        <id>itext</id>
        <name>iText Repository - releases</name>
        <url>https://repo.itextsupport.com/releases</url>
    <repository>
</repository>
```

Obs.: Apesar de estarem no projeto, elas ainda não foram usadas.
```
<dependencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <version>3.1.0</version>
  </dependency>
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.15.0</version>
  </dependency>
</dependencies>
```
