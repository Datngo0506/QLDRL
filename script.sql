USE [master]
GO
/****** Object:  Database [QLDRL]    Script Date: 5/6/2024 9:31:04 PM ******/
CREATE DATABASE [QLDRL]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLDRL', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLDRL.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLDRL_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLDRL_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLDRL] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLDRL].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLDRL] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLDRL] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLDRL] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLDRL] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLDRL] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLDRL] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLDRL] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLDRL] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLDRL] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLDRL] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLDRL] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLDRL] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLDRL] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLDRL] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLDRL] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLDRL] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLDRL] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLDRL] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLDRL] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLDRL] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLDRL] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLDRL] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLDRL] SET RECOVERY FULL 
GO
ALTER DATABASE [QLDRL] SET  MULTI_USER 
GO
ALTER DATABASE [QLDRL] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLDRL] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLDRL] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLDRL] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLDRL] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLDRL] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLDRL', N'ON'
GO
ALTER DATABASE [QLDRL] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLDRL] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLDRL]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[MaChucVu] [nchar](4) NOT NULL,
	[TenChucVu] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[MaChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CoVan]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CoVan](
	[MaCoVan] [nchar](7) NOT NULL,
	[TenCoVan] [nvarchar](50) NULL,
	[Khoa] [nchar](6) NOT NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[Sdt] [nchar](12) NULL,
	[Email] [nvarchar](200) NULL,
	[QueQuan] [nvarchar](300) NULL,
	[DiaChi] [nvarchar](300) NULL,
 CONSTRAINT [PK_CoVan] PRIMARY KEY CLUSTERED 
(
	[MaCoVan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DRLSV]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DRLSV](
	[MaDRL] [nchar](10) NOT NULL,
	[MSSV] [nchar](10) NOT NULL,
	[MaTC_HK] [nchar](6) NOT NULL,
	[DiemSV] [int] NULL,
	[DiemCS] [int] NULL,
	[DiemCV] [int] NULL,
	[Ketqua] [nchar](10) NULL,
 CONSTRAINT [PK_DRLSV] PRIMARY KEY CLUSTERED 
(
	[MaDRL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HK_NK]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HK_NK](
	[MaHK_NK] [nchar](11) NOT NULL,
	[HocKy] [int] NULL,
	[NienKhoa] [nchar](9) NULL,
 CONSTRAINT [PK_HocKyNienKhoa] PRIMARY KEY CLUSTERED 
(
	[MaHK_NK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khoa](
	[MaKhoa] [nchar](6) NOT NULL,
	[TenKhoa] [nvarchar](50) NULL,
	[NgayThanhLap] [date] NULL,
 CONSTRAINT [PK_Khoa] PRIMARY KEY CLUSTERED 
(
	[MaKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhoaHoc]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhoaHoc](
	[MaKhoaHoc] [nchar](9) NOT NULL,
	[NamBD] [nchar](4) NULL,
	[MamKT] [nchar](4) NULL,
	[TGHoc] [float] NULL,
 CONSTRAINT [PK_KhoaHoc] PRIMARY KEY CLUSTERED 
(
	[MaKhoaHoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lop]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lop](
	[Lop] [nchar](11) NOT NULL,
	[MaKhoa] [nchar](6) NOT NULL,
	[MaCoVan] [nchar](7) NOT NULL,
	[MaKhoaHoc] [nchar](9) NULL,
 CONSTRAINT [PK_Lop] PRIMARY KEY CLUSTERED 
(
	[Lop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MSSV] [nchar](10) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Lop] [nchar](11) NOT NULL,
	[ChucVu] [nchar](4) NOT NULL,
	[GioiTinh] [bit] NULL,
	[Sdt] [nchar](12) NULL,
	[Email] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[QueQuan] [nvarchar](50) NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[MSSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTK] [nchar](8) NOT NULL,
	[TenTK] [nvarchar](15) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[LoaiTk] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[MaTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TBChamDiem]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TBChamDiem](
	[MaTB] [nchar](5) NOT NULL,
	[MaHK_NK] [nchar](11) NOT NULL,
	[NgayBD] [date] NULL,
	[NgayKT_SV] [date] NULL,
	[NgayKT_CS] [date] NULL,
	[NgayKT_CV] [date] NULL,
	[NgayKT_Khoa] [date] NULL,
	[NgayCongBo] [date] NULL,
 CONSTRAINT [PK_TBChamDiem] PRIMARY KEY CLUSTERED 
(
	[MaTB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TC_HK]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TC_HK](
	[MaTC_HK] [nchar](6) NOT NULL,
	[MaTC] [nchar](5) NULL,
	[MaHK] [nchar](11) NULL,
	[DiemToiDa] [int] NULL,
 CONSTRAINT [PK_TC_HK] PRIMARY KEY CLUSTERED 
(
	[MaTC_HK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TieuChiDanhGia]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TieuChiDanhGia](
	[MaTieuChi] [nchar](5) NOT NULL,
	[NoiDung] [nvarchar](200) NULL,
 CONSTRAINT [PK_TieuChiDanhGia] PRIMARY KEY CLUSTERED 
(
	[MaTieuChi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrangThaiDuyet]    Script Date: 5/6/2024 9:31:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrangThaiDuyet](
	[MaTrangThai] [nchar](12) NOT NULL,
	[MaHK_NK] [nchar](11) NOT NULL,
	[MSSV] [nchar](10) NOT NULL,
	[TrangThai] [nchar](10) NULL,
	[DiemTong] [int] NULL,
 CONSTRAINT [PK_TrangThaiDuyet] PRIMARY KEY CLUSTERED 
(
	[MaTrangThai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV01', N'Lớp trưởng')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV02', N'Lớp phó')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV03', N'Bí thư chi đoàn')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV04', N'Sinh viên thường')
GO
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0001 ', N'Ngô Văn Đạt', N'ATTT  ', 1, CAST(N'2003-06-05' AS Date), N'0352752950  ', N'nguyenvandat@ptithcm.edu.vn', N'Tây Hòa, Phú Yên', N'Bình Thọ, Thủ Đức')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0002 ', N'Nguyễn Ngọc Yên Bình', N'ATTT  ', 0, CAST(N'2003-08-27' AS Date), N'0357701070  ', N'nguyenngocyenbinh2708@gmail.com', N'Tây Hòa, Phú Yên', N'Hiệp Bình Chánh, Thủ Đức')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0003 ', N'Trần Bình Minh Sáng Lạng', N'CNTT  ', 1, CAST(N'1993-06-10' AS Date), N'0352752990  ', N'tranbinhminh@gmail.com', N'Phú Yên', N'Thủ Đức')
GO
INSERT [dbo].[DRLSV] ([MaDRL], [MSSV], [MaTC_HK], [DiemSV], [DiemCS], [DiemCV], [Ketqua]) VALUES (N'DRL0001   ', N'N21DCAT001', N'TC0001', 3, 4, 5, N'5         ')
INSERT [dbo].[DRLSV] ([MaDRL], [MSSV], [MaTC_HK], [DiemSV], [DiemCS], [DiemCV], [Ketqua]) VALUES (N'DRL0002   ', N'N21DCAT001', N'TC0002', NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa]) VALUES (N'2023-2024-1', 1, N'2023-2024')
GO
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'ATTT  ', N'An toàn thông tin', CAST(N'1995-05-07' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'CNTT  ', N'Công nghệ thông tin', CAST(N'1997-11-07' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'DKTD  ', N'Điều khiển tự động hóa', CAST(N'1997-07-11' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'DPT   ', N'Đa phương tiện', CAST(N'1997-11-07' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'DTVT  ', N'Viễn thông 2', CAST(N'1997-07-11' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'KT    ', N'Kế toán', CAST(N'1997-07-11' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'KTDT  ', N'Điện tử', CAST(N'1997-07-11' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'MKT   ', N'Marketing', CAST(N'1997-07-11' AS Date))
GO
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2021-2026', N'2021', N'2026', 4.5)
GO
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQAT01-N', N'CNTT2 ', N'CVAT001', N'2021-2026')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQCN01-N', N'CNTT2 ', N'CVCN001', N'2021-2026')
GO
INSERT [dbo].[SinhVien] ([MSSV], [HoTen], [Lop], [ChucVu], [GioiTinh], [Sdt], [Email], [DiaChi], [QueQuan]) VALUES (N'N21DCAT001', N'Ngô Văn A', N'D21CQAT01-N', N'CV01', 1, N'0352752980  ', N'ngovana@gmail.com', N'Phú Yên', N'Phú Yên')
INSERT [dbo].[SinhVien] ([MSSV], [HoTen], [Lop], [ChucVu], [GioiTinh], [Sdt], [Email], [DiaChi], [QueQuan]) VALUES (N'N21DCCN001', N'Trần Thị C', N'D21CQCN01-N', N'CV04', 0, N'0736737873  ', N'tranthic@gmail.com', N'Phú Thọ', N'Phú Thọ')
GO
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKAD01  ', N'Admin1', N'Admin', N'admin')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKAD02  ', N'Admin2', N'Admin', N'admin')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0001', N'CV0001', N'dat123', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0002', N'CV0002', N'12345', N'CoVan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0003', N'CV0003', N'12345', N'CoVan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH01  ', N'ATTT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH02  ', N'CNTT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH03  ', N'DKTD', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH04  ', N'DPT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH05  ', N'DTVT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH06  ', N'KT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH07  ', N'KTDT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH08  ', N'MKT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH09  ', N'IOT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH10  ', N'AIT', N'12345', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKH11  ', N'123', N'12345', N'khoa')
GO
INSERT [dbo].[TBChamDiem] ([MaTB], [MaHK_NK], [NgayBD], [NgayKT_SV], [NgayKT_CS], [NgayKT_CV], [NgayKT_Khoa], [NgayCongBo]) VALUES (N'TB001', N'2023-2024-1', CAST(N'2024-04-30' AS Date), CAST(N'2024-05-05' AS Date), CAST(N'2024-05-10' AS Date), CAST(N'2024-05-15' AS Date), CAST(N'2024-05-20' AS Date), CAST(N'2024-05-25' AS Date))
GO
INSERT [dbo].[TC_HK] ([MaTC_HK], [MaTC], [MaHK], [DiemToiDa]) VALUES (N'TC0001', N'TC001', N'2023-2024-1', 5)
INSERT [dbo].[TC_HK] ([MaTC_HK], [MaTC], [MaHK], [DiemToiDa]) VALUES (N'TC0002', N'TC002', N'2023-2024-1', 6)
GO
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung]) VALUES (N'TC001', N'Đi học đầy đủ')
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung]) VALUES (N'TC002', N'Quá xinh gái')
GO
INSERT [dbo].[TrangThaiDuyet] ([MaTrangThai], [MaHK_NK], [MSSV], [TrangThai], [DiemTong]) VALUES (N'TT001       ', N'2023-2024-1', N'N21DCAT001', N'Duyet     ', 78)
GO
ALTER TABLE [dbo].[DRLSV]  WITH CHECK ADD  CONSTRAINT [FK_DRLSV_SinhVien] FOREIGN KEY([MSSV])
REFERENCES [dbo].[SinhVien] ([MSSV])
GO
ALTER TABLE [dbo].[DRLSV] CHECK CONSTRAINT [FK_DRLSV_SinhVien]
GO
ALTER TABLE [dbo].[DRLSV]  WITH CHECK ADD  CONSTRAINT [FK_DRLSV_TC_HK] FOREIGN KEY([MaTC_HK])
REFERENCES [dbo].[TC_HK] ([MaTC_HK])
GO
ALTER TABLE [dbo].[DRLSV] CHECK CONSTRAINT [FK_DRLSV_TC_HK]
GO
ALTER TABLE [dbo].[Lop]  WITH CHECK ADD  CONSTRAINT [FK_Lop_KhoaHoc] FOREIGN KEY([MaKhoaHoc])
REFERENCES [dbo].[KhoaHoc] ([MaKhoaHoc])
GO
ALTER TABLE [dbo].[Lop] CHECK CONSTRAINT [FK_Lop_KhoaHoc]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_ChucVu] FOREIGN KEY([ChucVu])
REFERENCES [dbo].[ChucVu] ([MaChucVu])
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_ChucVu]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_Lop] FOREIGN KEY([Lop])
REFERENCES [dbo].[Lop] ([Lop])
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_Lop]
GO
ALTER TABLE [dbo].[TBChamDiem]  WITH CHECK ADD  CONSTRAINT [FK_TBChamDiem_HK_NK] FOREIGN KEY([MaHK_NK])
REFERENCES [dbo].[HK_NK] ([MaHK_NK])
GO
ALTER TABLE [dbo].[TBChamDiem] CHECK CONSTRAINT [FK_TBChamDiem_HK_NK]
GO
ALTER TABLE [dbo].[TC_HK]  WITH CHECK ADD  CONSTRAINT [FK_TC_HK_HocKyNienKhoa] FOREIGN KEY([MaHK])
REFERENCES [dbo].[HK_NK] ([MaHK_NK])
GO
ALTER TABLE [dbo].[TC_HK] CHECK CONSTRAINT [FK_TC_HK_HocKyNienKhoa]
GO
ALTER TABLE [dbo].[TC_HK]  WITH CHECK ADD  CONSTRAINT [FK_TC_HK_TieuChiDanhGia] FOREIGN KEY([MaTC])
REFERENCES [dbo].[TieuChiDanhGia] ([MaTieuChi])
GO
ALTER TABLE [dbo].[TC_HK] CHECK CONSTRAINT [FK_TC_HK_TieuChiDanhGia]
GO
ALTER TABLE [dbo].[TrangThaiDuyet]  WITH CHECK ADD  CONSTRAINT [FK_TrangThaiDuyet_HK_NK] FOREIGN KEY([MaHK_NK])
REFERENCES [dbo].[HK_NK] ([MaHK_NK])
GO
ALTER TABLE [dbo].[TrangThaiDuyet] CHECK CONSTRAINT [FK_TrangThaiDuyet_HK_NK]
GO
ALTER TABLE [dbo].[TrangThaiDuyet]  WITH CHECK ADD  CONSTRAINT [FK_TrangThaiDuyet_SinhVien] FOREIGN KEY([MSSV])
REFERENCES [dbo].[SinhVien] ([MSSV])
GO
ALTER TABLE [dbo].[TrangThaiDuyet] CHECK CONSTRAINT [FK_TrangThaiDuyet_SinhVien]
GO
USE [master]
GO
ALTER DATABASE [QLDRL] SET  READ_WRITE 
GO
