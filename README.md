### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

### Additional Links Regarding to Thymeleaf
* [Thymeleaf Document](https://www.thymeleaf.org/documentation.html)
* [Using Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html)
* [Using Thymeleaf + Spring](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html)
* [Extending Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.1/extendingthymeleaf.html)
### Getting started
`
++ src/main/resources/
  ++ static -> css, js, html, etc
  ++ template -> themeleaf html
  ++ file.properties
`
#### 1. Thymeleaf Template
Including:
1. Templates Attributes : Thymeleaf Attributes(eg. th:text), HTML Attributes(eg. th:title)
2. Standard Expressions : ${...}, *{...}, @{...}, ~{...}, #{...}
### 2. Thymeleaf Attributes
1. Các fragment : th:insert, th:place
2. Vòng lặp : th:each
3. Đánh giá : th:if, th:unless, th:switch, th:case
4. Hiệu chỉnh thuộc tính: th:attr, th:attrprepend, th: attrappend
5. Hiệu chỉnh thuộc tính HTML: th:value, th:href
6. Thay đổi nội dung thẻ: , th:text, th:text
7. Khai báo fragment: th:fragment
8. Xoá fragment: th:remove
### 3. Standard Expressions
1. `${...}`: Variable Expressions -> `Scope` and `Parameters`
2. `*{...}`: Selection Expressions -> Thuộc tính của th:object
3. `#{...}`: Message Expressions -> i18n resourse (.properties)
4. `@{...}`: URL expressions -> URL/URI (th:src, th:href)
5. `~{...}`: fragement expression -> layout(th:insert, th:replace)
### 3.1 `${...}`: Variable Expressions
- `<span th:text="${user.name}">` => hiển thị thuộc tính name trong bean user trong model(request).
- `<li th:each="book : ${books}" th:text = "${book.title}">` => Duyệt tập hợp books trong model and hiện thị title trong mỗi book.
- `<span th:text="${session.user.uname}">` => Hiển thị thuộc tính name của bean user trong session scope
- `<span th:text="${application.user.name" >` => Hiển thị thuộc tính name của bean user trong context scope
- `<span th:text="${param.name}">` => Hiển thị tham số name
### 3.2 `*{...}`: Selection Expressions 
```html
<ul th:object="${book}">
    <li th:text = "*{title}"></li>
    <li th:text = "*{publisher}"></li>
    <li th:text = "${book.name}"></li>
</ul>
```
### 3.3 `#{...}`: Message Expressions 
1. menu.properties
```properties
menu.home = Home
```
2. menu_vi.properties
```properties
menu.home = Trang chủ
```
```html
<ul >
    <li th:text = "#{menu.home}"></li>
</ul>
```
### 3.4 `@{...}`: URL expressions
- Root relative URL (tương đối so với URL gốc-webroot)
```html
<a th:href="@{/order/list}"></a> 
```
==>
```html
<a href="/ctxpath/order/list"></a>
```
- Page Relative URL (tương đối so vơi URL hiện tại)
```html
<a th:href="@{../order}"></a>
```
==> 
```html
<a href="../order"></a>
```
```html
<a th:href="@{order/list}"></a>
```
==>
```html
<a href="order/list"></a>
```
- Protocol Relative And Absolute URL
```html
<a th:href = "@{//www.poly.com/order/list}"></a>
```
==> 
```html
<a href = "//www.poly.com/order/list"></a>
```
```html
<a th:href = "@{https://www.poly.com/order/list}"></a>
```
==>
```html
<a href = "https://www.poly.com/order/list"></a>
```
### 4. Parameters and PathVariables
1. Parameters => Có 3 cách tạo ra
```html
 <th:book th:with="x='X', y='Y'">
    <a th:href="@{/order/details(a=${x}, b=${y})}"></a>
    <a th:href="@{|/order/details?a=${x}&b=${y}|}"></a>
    <a th:href="@{'/order/details?a='+ ${x} + '&b=' + ${y}}"></a>
</th:book>
```
===>
```html
<a href="/order/details?a=X&b=Y"></a>
```

2. PathVariables =>
```html
<th:block th:with="x='X', y='Y'>
    <a th:href="@{/order/{a}/details/{b}(a=${x},b=${y})}"> </a>
    <a th:href="@{|/order/${x}/details/${x}|}"> </a>
    <a th:href="@{'/order/'+ ${a}+ '/details/' +${b}}"> </a>
</th:block>
```
===>
```html
<a href="/order/X/details/Y"></a>
```
Explain:
- `th:block`: tạo khối
- `th:with`: dùng để khai báo biến trong 1 block
### 5. `~{...}`: fragement expression 
Fragment Expressions được sử dụng để sao chép một file hoặc một fragment template đươc định nghĩa trước vào các vị trí mong muốn
- `<div th:insert="~{/menu.html}">` ==> Thay thế nội dung thẻ div bằng nội dung file menu.html
- `<div th:replace="~{/menu.html}">` ==> Thay thế thẻ div bằng nội dung file menu.html
- `<div th:insert="~{/fragments.html::menu}">` ==> Thay thế nội dung thẻ div bằng fragment có tên là menu trong file fragments.html
- `<div th:replace="~{/fragments.html::menu}">` ==> Thay thế thẻ div bằng fragment có tên là menu trong file fragments.html
### 6. Thymeleaf Operators
- `String`: + , |...${}...|(thymeleaf3), [[expr]], [(expr)]
- Arithmetic: +, - , * , / , %
- Logic: and, or, not (!)
- Comparison: < (lt), <= (le), > (gt), >= (ge), == (eq), != (ne)
- Conditional: condition ? trueValue: falseValue
Eg:
```html
<ul th:with="x='X', y='<b><i>Y</i></b>'">
  <li th:utext="${x} + ${y}"></li>
  <li th:utext="| Value of y is ${y} |"></li>
  <li>Hello [[${y}]]</li>
  <li >[(${y})]</li>
</ul>
<ul>
  <li th:text="${x+y}"></li>
  <li th:text="${x%y}"></li>
  <li th:text="${x*y}"></li>
  <li th:text="${x - y}"></li>
  <li th:text="${x / y}"></li>
  <li th:text="not ${x>y} "></li>
  <li th:text="${x gt y} and ${x==y} "></li>
  <li th:text="${x > y} ?  'OK' : 'Cancel' "></li>
  <li th:text="@{|/a/b/${x}/${y}|} "></li>
  <li >[[${message}]]Hoang Hieu</li>
  <li >Cong: [[${x+y}]]</li>
</ul>
```
```html
<ul th:object="${bean}">
  <li>Fullname: <b th:text="*{fullname}"></b></li>
  <li>
    Marks:
    <b th:text="*{mark}"></b>
    (<i th:text="*{mark >= 5.0 ? 'Passed':'Failed'"></i>)
  </li>
  <li>
    <b th:if = "*{marks>9.0}">Golden Bee</b>
  </li>
</ul>

```
### 7. Flow Control Attributes
1. th:each
- `th:each="item: ${iterable}"` :  iterable is a list
- th:each="item, state: ${iterable}" : state including: index
- th:each="entry: ${iterable}" : entry is a key-value pair
- th:each="entry, state: ${iterable}" : 
2. th:if
- `th:if="expr"` : true (true, != null, !="" )
- `th:unless="expr"` : if else
3. th:switch
```html
<any th:switch="expr">
  <any th:case="v1"></any>
</any th:case="*" > same default in switch-case
```
### 8. Thymeleaf Utilities
1. `Servlet Implicit Object`: Thymeleaf định nghĩa sẵn các đối tượng servlet: `request`, `response`, `session`, `serveletContext`, `locale`, từ đó
gọi các phương thúc để thục hiện:
- `${#request.getRequestURL()}`
- `${#session.getId()}`
- `${#servletContext.getContextPath()}`
- `${#locale.getLanguages()}`
Note: Thymeleaf cho phpes áp dụng theo quy ước JavaBean đối với các getter
- `${#request.requestURL}`
- `${#session.id}`
- `${#servletContext.contextPath}`
- `${#locale.language}`
2. `Impicit Uility Objects` Thymeleaf cung cấp các đối tượng ngầm định chứa các phương thức tiện ích hỗ trợ xử lý trong Template
- `#message`: Xử lý tài nguyên đa ngôn ngữ
==> eg. ${#message.msg('key', param1, param2)}
- `#dates`: xử lý thời gian
==> eg. ${#dates.format(date, parttern)}
- `#numbers`: Xử lý số
==> eg. ${#numbers.formatDecimal(marks, 0, 'WHITESPACE',2,'POINT')}
- `#strings`: Xử lý chuỗi
==> eg. ${#strings.capitalizeWords(str)}
- `#arrays`: xử lý mảng
==> eg. ${#arrays.length(array)}
- `#lists`: xử lý danh sách
==> eg. ${#lists.size(list)}
- `#aggregates:` tổng hợp dữ liệu từ collection, arrays, mapp
==> eg. ${#aggregates.sum(array)}
```html
<ul th:object="${student}">
  <li>
    Fullname: <b th:text="*{#strings.capitalizeWords(fullname)}">
  </b>
  <li>
    Marks: <b th:text="*{#numbers.formatDecimal(marks, 0, 'COMMA', 2, 'POINT')}">
  </b>
  <li>
    Birthday: <b th:text="*{#dates.format(dob, 'dd-MM-yyyy')}">
  </b>
  
  </li>
</ul>
<body>
<h3> UTILITY OBJECT</h3>
<b>TỔNG HỢP</b>
<ul>
  <li>
    Today: <i th:text="${#dates.format(now, 'EEE, dd-MM-yyyy')}"></i>
  </li>
  <li>
    Number of students : <i th:text="${#lists.size(students)}"></i>
  </li>
</ul>
<h2>DANH SÁCH</h2>
<ul th:each="student: ${students}" th:object="${student}">
  <li>
    Name: <b th:text="*{#strings.capitalizeWords(name)}"></b>
  </li>
  <li>
    Marks: <b th:text="*{#numbers.formatDecimal(marks, 0,  'COMMA', 2, 'POINT')}"></b>
  </li>
  <li>
    Number of subjects: <b th:text="*{#arrays.length(subjects)}"></b>
  </li>
</ul>
</body>
</html>
```
### 9. Databinding and Validation
1. HTML Thymeleaf
```html
<form th:action="/validation" th:object="student">
  
</form>

```
2.Request Mapping
```java
@RequestMapping("/validation")

```
3.Model and Validation Model
```java
@Data
public class Student{
    @NotBlank(message="Khong de trong email")
    @Email(message="Khong dung dinh dang email")
    private String email;
    @NotBlank(messsage= "Khong de trong ho va ten")
    private String fullname;
    @NotNull(message = "Khong de trong diem")
    @Max(value=10, message="Diem khong the tren 10")
    @PositiveOrZero(message="Diem khong the am")
    private Double marks;
    @NotNull(message="Chua chon gioi tinh")
    private Boolean gender;
    @NotBlank(message= "Chua chon quoc tich")
    private String country;
}
```
Note: `NotBlank` => String, `NotEmpty` => String, Collection, `NotNull` => Object
4. Dependency 
```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
5. Number Validation Annotaion
- Min, Max, DecimalMin, DecimalMax
- Positive, PositiveOrZero, Negative, NegativeOrZero
- Digits
6. String Validation Annotaion
- Email, Pattern
- Not Blank
7. List Validation Annotaion
- NotEmpty, Size
8. Time Validation Annotaion
- Past, PastOrPresent, Future, FutureOrPresent
9. Other
- NotNull, AssertFalse, AssertTrue, Null
10. Thymeleaf Form Template
- Phan tu form va thuoc tinh Thymeleaf
```html
<form th:action="@{url}" th:object="${bean}">
  <input th:field="*{property}"/>
  <input th:field="*{property}"/>
  <select th:field="*{property}"/>
  <textarea th:field="*{property}"/>
  <any th:error="*{property}"/>
  <button></button>
</form>
```
- Mot so the hoac thuoc tinh bo tro:
- - `<label>`
- - `th:selected`
- - `th:disabled`
- - `th:readonly`
- DEMO:
```html
<form th:action="@{/validation}" th:object="${student}" method="post">
  <input th:field="*{email}"/>
  <input th:field="*{fullname}"/>
  <input th:field="*{marks}"/>
  <input th:field="*{gender}" type="radio" value="true"/>
  <textarea th:field="*{property}"/>
  <any th:error="*{property}"/>
  <button>Validation</button>
</form>
```
11. Validation Controller
```java
  @GetMapping(/validator)
  public String validate(Model model, @ModelAttribute Student student){
    return "valiation-form"
}

@PostMapping(/validator)
public String validate(Model model, @Valid @ModelAttribute Student student, Errors errors){
        if (errors.hasErros()){
            model.addAttribute("message", "Vui long sua cac loi sau");
        }  
        else{
            model.addAttribute("message", "Tat ca da hop le")
        }
        return "validation-form";
        }   
```
12. Display errors
```html
<form th:action="@{/validation}" th:object="${student}" method="post">
  <input th:field="*{email}"/>
  <i th:error="*{email}"></i>
  <input th:field="*{fullname}"/>
  <i th:error="*{fullname}"></i>
  <input th:field="*{marks}"/>
  <i th:error="*{marks}"></i>
  <input th:field="*{gender}" type="radio" value="true"/>
  <textarea th:field="*{property}"/>
  <any th:error="*{property}"/>
  <button>Validation</button>
</form>
```
13. Using Select box
```html
<select th:field="*{country}">
  <option value=""></option>
  <option th:each="c: ${countries}" th:value="${c.key}">[[${c.value}]]</option>
</select>
```
- ModelAttributes cho countries
```java
@ModelAttributes("countries")
public Map<String, String > getCountries(){
        Map<String, String> map = new HashMap<>();
        map.put("VN", "VietNam");
        map.put("US", "United States");
        }
```
14. Error Message Resource
```java
@Data
public class Student{
    @NotBlank
    @Email
    private String email;
}
```
- Tao file resource
- - `Annotation.bean.property` syntax
- - `<form th:object=${student}></form>`
- - student_en.properties
```properties
NotBlank.student.email = Email is required
....
```
- - student_vi.properties
```properties
NotBlank.student.email = Khong de trong email
....
```
### 10. Layout Organization
1. Fragments
```html
<!-- frags.html-->  
<html xmlns:th=http://www.thymeleaf.org">
    <div th:fragment="frag1">
        <h3>Fragment 1</h3>
    </div>
    <div th:fragment="frag2(x,y)">
      <h3>Fragment [[${x}]] and [[${y}]]</h3>
    </div>
</html>
```
```html
<!-- page.html-->
<!DOCTYPE html>
<html xmlns:th=http://www.thymeleaf.org">
<head>
  <meta charset="utf-8">
</head>
<body th:with="y='Hicode'">
    <div th:replace="~{frags::frag1}"></div>
    <hr>
    <div th:replace="~{frags::frag2(~{::#x/text()}, ${y})}"></div>
    <i id="x" th:remove="all">Hieu</i>
</body>
</html>
```
Explain:
- `~{frags::frag1}`: get frag1 in frags.html
- `~{::#x/text()}` : get text in `<i id="x" th:remove="all">Hieu</i>`
2. Syntax
- th:fragment: `th:fragment="name"`, `th:fragment="name(params)"`
- th:replace and th:insert
- - `th:replace = "~{file::selector(param)}"`
- - `th:replace = "~{file::selector}"`
- - `th:replace = "~{file}"`
- - `th:replace = "~{::selector}"` ==> tim slector phu hop trong trang do
Note:
- Selector => including: fragment name, css selector
3. Phan biet th:replace(thay the the do bang mang) va th:insert(lay mang bo vao giua the do)
4. th:remove="all" => xoa 1 the va noi dung no khoi trang web
5. Demo
```html
  <div th:fragment="frag1"></div>
    <div th:fragment="frag2(x,y)"></div>
    <div class="myclass"></div>
    <div id="myid"></div>
```
```html
<div th:replace="frags::frag1"></div>
<div th:replace="frags::frag2(~{::#x},)"></div>
<div th:replace="frags::.myclass"></div>
<div th:replace="frags::#myid"></div>
<i id="x" th:remove="all">Hieu</i>
```
6. LayoutDesign
- layout.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" th:fragment="areas(title, body)">
    <head>
      <meta charset="utf-8">
      <title th:replace="${title}"></title>
    </head>
    <body>
        <div th:replace="~{menu:hnav}"></div>
    <hr>
        <div th:replace="${body}"></div>
    </body>
</html>
```
- menu.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" th:fragment="areas(title, body)">
    <nav th:fragment="hnav">
        <a></a>
    </nav>
</html>
```
- home.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" th:replace="~{layout::areas(~{::title}, ~{::main})}">
    <head>
      <title>Home Pages</title>
    </head>
<body>
    <main>
        <h1>This is home age</h1>
    </main>
</body>
</html>
```
### 11. Internationalization I18N (Multi Languages)
1. Soạn tài nguyên đa ngôn ngữ
- Mã ngôn ngữ : _vi.properties, _en.properties
2. Câu hình nạp từ nguyên đa ngôn ngữ vào hệ thống

```java
import java.util.Locale;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
  @Bean("messageSource")
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasenames("classpath:menu", "classpath:i18n/menu");
    return messageSource;
  }

  /**
   * Maintain locale
   * */
  @Bean("localeResolve")
  public LocalResolve getResolve() {
    CookieLocaleResolver resolver = new CookieLocaleResolver();
    resolver.setCookiePath("/");
    resolver.setCookieMaxAge(10 * 24 * 60 * 60);
    resolver.setDefaultLocale(new Locale("vi"));
    return resolver;
  }

  @Override
  public void addInterceptor(InterceptorRegistry registry) {
  }
}
```
3. Cấu hinh cách duy trì ngôn ngữ được chọn (cookie/session)
```java
  /**
   * Maintain locale
   * */
  @Bean("localeResolve")
  public LocalResolve getResolve() {
    CookieLocaleResolver resolver = new CookieLocaleResolver();
    resolver.setCookiePath("/");
    resolver.setCookieMaxAge(10 * 24 * 60 * 60);
    resolver.setDefaultLocale(new Locale("vi"));
    return resolver;
  }
```
4. Hiển thị tài nguyên đa ngôn ngữ lên giao diện
```html
<a th:href="@{/layout/index}">[[#{menu.home}]]</a>
```
5. Cấu hinh tham số thay đổi ngôn ngữ (?lang)
```java
  @Override
  public void addInterceptor(InterceptorRegistry registry) {
    LocaleChangeInterceptor locale = new LocaleChangeInterceptor();
    locale.setParamName("lang");
    registry.addInterceptor(locale).addPathPatterns("/**");
  }
```
- `url?lang=vi`
- `url>lang=en`
6. Lựa chọn ngôn ngữ
- static
```html
<a href="?lang=vi">Tieng anh</a>
<a href="?lang=en">Tieng viet</a>
```
- Ajax JQUERY
```html

<script >
  $(function () {
        $("a[href*=lang").click(function () {
          $ajax({
            url: "/layout/home"+ $(this).attr("href")
          })
                  .then(resp=>location.reload())
        })
    return false;
  })
</script>
```
