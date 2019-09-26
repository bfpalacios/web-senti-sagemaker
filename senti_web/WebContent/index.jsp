<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">



<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!--title>SB Admin 2 - Dashboard</title-->

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">



	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<!--a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <!--div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div-->
			<!--div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div-->
			<!--/a-->

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="index.do">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>SENTI-WEB</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Men�</div>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="tables.do"> <i
					class="fas fa-fw fa-table"></i> <span>An�lisis de Respuestas
						de Sentimientos</span></a></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="index.do"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Resultado de
						An�lisis de Sentimientos</span></a></li>



			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<!--div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div-->

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
						action="#" method="post">
						<div class="input-group"
							class="d-sm-flex align-items-center justify-content-between mb-4">
							<!--h1 class="h3 mb-0 text-gray-800">CONSULTORA DE TI</h1-->
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1">
							<!--a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts --> <!--span class="badge badge-danger badge-counter">3+</span>
              </a--> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown"></div>
						</li>

						<!-- Nav Item - Messages -->

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">Karina
									Espejo</span> <!-- <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">-->
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<!--a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a-->
								<!--a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a-->
								<!--a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a-->
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Cerrar Sesi�n
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Reporte de An�lisis de
							Resultados</h1>
						<!--a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i>Descargar Reporte</a-->

					</div>
					<div class="my-2" align="center">
						<a href="#" class="btn btn-primary"> <span
							class="icon text-white-50"> </span> <span class="text">GENERAR
								REPORTE</span>
						</a>
					</div>

					<!-- Content Row -->
					<div class="row">
						<!-- RELACION -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">Indicador</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">Relaci�n
												con el Equipo</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Estrategia -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-success text-uppercase mb-1">Estrategia</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">Manejo
												de Conflictos</div>
										</div>

									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-info text-uppercase mb-1">Total
												de Encuestados</div>
											<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"
												align="center">${sessionScope.totalEncuestadoSession}</div>
										</div>

										<div class="col-auto">
											<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>

					<!-- Content Row -->

					<div class="row">

						<!-- Area Chart -->
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
									<div
										class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
										<h6 class="m-0 font-weight-bold text-primary">Indice del
										Grado de Satisfacci�n de los Colaboradores</h6>
										<div></div>
									</div>
									<!-- Card Body -->
									<div class="card-body">
										<div class="chart-pie">
											<canvas id="myPieChart"></canvas>
										</div>
										<div class="mt-4 text-center small">
											<span class="mr-2"> <i
											class="fas fa-circle text-primary"></i> Positivo
											</span> <span class="mr-2"> <i
											class="fas fa-circle text-success"></i> Negativo
											</span>
										</div>
									</div>
								</div>
							</div>
							
							<!-- Pie Chart -->
						<div class="col-xl-4 col-lg-10">
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Recomendaciones
										de los Colaboradores</h6>
								</div>
								<!-- Card Body -->
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<!-- div class="text-xs font-weight-bold text-success text-uppercase mb-1">Recomendaciones</div -->
										<div class="h11 mb-0 font-weight-bold text-gray-800">
											<c:forEach var="recomendacion"
												items="${sessionScope.recomendacionesSession }">
												<p>${recomendacion.descRpta}</p>

											</c:forEach>
										</div>
									</div>

								</div>




							</div>



						</div>	
						</div>
						
						<div class="row">
								<!-- COMENTARIOS POSITIVOS -->
								<div class="col-xl-6 col-md-2 mb-2">
									<div class="card border-left-primary shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-2">
													<div
														class="text-xs font-weight-bold text-primary text-uppercase mb-1">Comentarios
														Positivos</div>
													<div class="h11 mb-0 font-weight-bold text-gray-800">
														<c:forEach var="recomendacion"
															items="${sessionScope.respuestasPositivasSession }">
															<p>${recomendacion.descRpta}</p>

														</c:forEach>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

									<!-- COMENTARIOS NEGATIVOS -->
									
								<div class="col-xl-6 col-md-2 mb-2">
									<div class="card border-left-success shadow h-100 py-2">
										<div class="card-body">
											<div class="row no-gutters align-items-center">
												<div class="col mr-4">
													<div
														class="text-xs font-weight-bold text-success text-uppercase mb-1">Comentarios
														Negativos</div>
													<div class="h11 mb-0 font-weight-bold text-gray-800">
														<c:forEach var="recomendacion"
															items="${sessionScope.respuestasNegativasSession }">
															<p>${recomendacion.descRpta}</p>

														</c:forEach>
													</div>
												</div>

											</div>
										</div>
									</div>
									
									
									</div>
								


							
							
						</div>

						


					</div>

					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4"></div>

						<div class="col-lg-6 mb-4">

						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">�</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script>
  
  Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["Positivo", "Negativo"],
    datasets: [{
      data: [${sessionScope.positivoSession}, ${sessionScope.negativoSession}],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 20,
      yPadding: 80,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});

  
  
  </script>

</body>

</html>