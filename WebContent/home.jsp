<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
  
  <!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <div class="container-fluid" style="margin-bottom: 20px; margin-top: 50px">
      <div class="row">
        <div class="col-lg-8 offset-lg-2" style="text-align: center; float: left;">

        <form class="" action="getUSCityWeatherInformationByCity.do" method="post">
               <input type="text" name="usCity" placeholder="Enter a city">
              <input type="submit" name="submit" value="Submit">
         </form>
      </div>
      
 <c:if test = "${error != null}">
     <div class="container-fluid">

    <div class="col-sm-12">
    <div class="row">
      <div class="col-lg-12" style="text-align: center; font-weight: bold">
        <div class="weather-info-summary" style="color: red;">
          ${error}
        </div>
		 <c:forEach items="${cities}" var="city">
		 <a href="getUSCityWeatherInformationByCityAndCounty.do?usCity=${city.city}&county=${city.county}">${city.city}, ${city.county}, ${city.state.name }</a></br>
	</c:forEach>
      </div>
    </div>
  </div>
    </div>
      </c:if>
      
      
       <div class="col-lg-8 offset-lg-2" style="text-align: center; float: left; margin-top: 25px; font-size: 2em; font-weight: bold">
			${city.city}, ${city.county}, ${city.state.name}
        
      </div>
      </div>
    </div>
    <div class="container-fluid">

    <div class="col-sm-12">
    <div class="row">
      <div class="col-lg-12" style="text-align: center; font-weight: bold">
        <div class="weather-info-summary">
          	${weatherReport.summary }
        </div>
	     
      </div>
    </div>
      <div class="row">
              <div class="col-lg-0 offset-lg-1 ">
      </div>
      <c:forEach items="${weatherReport.weatherInformation}" var="weatherInfo">
      
        <div class="col-lg-2 col-md-6 col-xs-12">
          <div class="card" style="margin-top: 10%">
            <img class="card-img-top" src="./images/${weatherInfo.weatherStatus }.png" alt="Card image cap">
            <div class="card-body">
              <div class="" style="text-align:center">
                <h5 class="card-title">${weatherInfo.day.dayOfWeek }</h5>
              </div>
              <div class="" style="text-align:center; margin-bottom: 5px;">
                <p class="card-text">${weatherInfo.summary}</p>
              </div>
              <div class="" style="text-align:center; margin-top: 20%; font-style: italic; font-weight: bold">
              	Temp &deg;C
              </div>
              <div class="" style="text-align:center">
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  Low
                </div>
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  High
                </div>
                <div class="" style="text-align:center; width: 50%; float: left;">
                  ${weatherInfo.temperatureLow}
                </div>
                <div class="" style="text-align:center; width: 50%; float: left">
                  ${weatherInfo.temperatureHigh}
                </div>
              </div>
              <!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
            </div>
          </div>

        </div>
        </c:forEach>
        
     <!--    <div class="col-lg-2 col-md-6 col-xs-12">
          <div class="card" style="margin-top: 10%">
            <img class="card-img-top" src="./images/cloudy.png" alt="Card image cap">
            <div class="card-body">
              <div class="" style="text-align:center">
                <h5 class="card-title">Tuesday</h5>
              </div>
              <div class="" style="text-align:center; margin-bottom: 5px;">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              </div>
              <div class="" style="text-align:center">
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  Low
                </div>
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  High
                </div>
                <div class="" style="text-align:center; width: 50%; float: left;">
                  59
                </div>
                <div class="" style="text-align:center; width: 50%; float: left">
                  89
                </div>
            </div>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-xs-12">
          <div class="card" style="margin-top: 10%">
            <img class="card-img-top" src="./images/Partly-Cloudy-icon.png" alt="Card image cap">
            <div class="card-body">
              <div class="" style="text-align:center">
                <h5 class="card-title">Wednesday</h5>
              </div>
              <div class="" style="text-align:center; margin-bottom: 5px;">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              </div>
              <div class="" style="text-align:center">
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  Low
                </div>
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  High
                </div>
                <div class="" style="text-align:center; width: 50%; float: left;">
                  59
                </div>
                <div class="" style="text-align:center; width: 50%; float: left">
                  89
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-xs-12">
          <div class="card" style="margin-top: 10%">
            <img class="card-img-top" src="./images/rain.png" alt="Card image cap">
            <div class="card-body">
              <div class="" style="text-align:center">
                <h5 class="card-title">Thursday</h5>
              </div>
              <div class="" style="text-align:center; margin-bottom: 5px;">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              </div>
              <div class="" style="text-align:center">
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  Low
                </div>
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  High
                </div>
                <div class="" style="text-align:center; width: 50%; float: left;">
                  59
                </div>
                <div class="" style="text-align:center; width: 50%; float: left">
                  89
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-2 col-md-6 col-xs-12">
          <div class="card" style="margin-top: 10%">
            <img class="card-img-top" src="./images/clear.jpg" alt="Card image cap">
            <div class="card-body">
              <div class="" style="text-align:center">
                <h5 class="card-title">Friday</h5>
              </div>
              <div class="" style="text-align:center; margin-bottom: 5px;">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              </div>
              <div class="" style="text-align:center">
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  Low
                </div>
                <div class="" style="text-align:center; width: 50%; float: left; border-bottom: black solid 1px;">
                  High
                </div>
                <div class="" style="text-align:center; width: 50%; float: left;">
                  59
                </div>
                <div class="" style="text-align:center; width: 50%; float: left">
                  89
                </div>
              </div>
            </div>
          </div>
        </div> -->
      </div>
    </div>

</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
 <%--    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello

<form action="getUSCityWeatherInformation.do"  method="GET">
<input type="submit" name="submit" value="submit" />
<input type="text" name="city" value="city" />
 <c:if test = "${error != null}">
         <p><c:out value = "${error}"/><p>
      </c:if>
</form>

<c:forEach items="${cityWeatherInformation}" var="weatherInfo">
summary: ${weatherInfo.summary} </br>
temperatureHigh: ${weatherInfo.temperatureHigh} </br>
temperatureLow: ${weatherInfo.temperatureLow} </br>
temperatureHighTime: ${weatherInfo.temperatureHighTime} </br>
temperatureLowTime: ${weatherInfo.temperatureLowTime} </br></br>
________________________________________________

</c:forEach>
</body>
</html> --%>