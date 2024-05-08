USE [master]
GO
/****** Object:  Database [QLDRL]    Script Date: 5/8/2024 11:22:37 PM ******/
CREATE DATABASE [QLDRL]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLDRL', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLDRL.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLDRL_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLDRL_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
/****** Object:  Table [dbo].[ChucVu]    Script Date: 5/8/2024 11:22:37 PM ******/
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
/****** Object:  Table [dbo].[CoVan]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[DRLSV]    Script Date: 5/8/2024 11:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DRLSV](
	[MaDRL] [nchar](10) NOT NULL,
	[MSSV] [nchar](10) NOT NULL,
	[MaHK_NK] [nchar](6) NOT NULL,
	[DiemSV] [int] NULL,
	[DiemCS] [int] NULL,
	[DiemCV] [int] NULL,
	[Ketqua] [nchar](10) NULL,
	[TrangThai] [nchar](10) NULL,
 CONSTRAINT [PK_DRLSV] PRIMARY KEY CLUSTERED 
(
	[MaDRL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaiThichTieuChi]    Script Date: 5/8/2024 11:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaiThichTieuChi](
	[MaTieuChi] [nchar](5) NOT NULL,
	[NoiDung] [nvarchar](500) NULL,
	[DiemQD] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HK_NK]    Script Date: 5/8/2024 11:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HK_NK](
	[MaHK_NK] [nchar](11) NOT NULL,
	[HocKy] [int] NULL,
	[NienKhoa] [nchar](9) NULL,
	[Xet] [bit] NULL,
 CONSTRAINT [PK_HocKyNienKhoa] PRIMARY KEY CLUSTERED 
(
	[MaHK_NK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[KhoaHoc]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[Lop]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[SinhVien]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[TBChamDiem]    Script Date: 5/8/2024 11:22:38 PM ******/
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
/****** Object:  Table [dbo].[TieuChiDanhGia]    Script Date: 5/8/2024 11:22:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TieuChiDanhGia](
	[MaTieuChi] [nchar](5) NOT NULL,
	[NoiDung] [nvarchar](500) NULL,
	[DiemQD] [int] NULL,
 CONSTRAINT [PK_TieuChiDanhGia] PRIMARY KEY CLUSTERED 
(
	[MaTieuChi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV01', N'Lớp trưởng')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV02', N'Lớp phó')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV03', N'Bí thư chi đoàn')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'CV04', N'Sinh viên')
GO
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0001 ', N'Nguyễn Văn An', N'CB2   ', 1, CAST(N'1990-01-01' AS Date), N'0123456789  ', N'CV0001@ptithcm.edu.vn', N'Hà Nội', N'Quận 1, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0002 ', N'Trần Thị Linh', N'CB2   ', 0, CAST(N'1992-03-15' AS Date), N'0987654321  ', N'CV0002@ptithcm.edu.vn', N'Hồ Chí Minh', N'Quận 2, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0003 ', N'Lê Anh Tuấn', N'CB2   ', 1, CAST(N'1985-05-20' AS Date), N'0369852147  ', N'CV0003@ptithcm.edu.vn', N'Hải Phòng', N'Quận 3, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0004 ', N'Phạm Thị Hương', N'CB2   ', 0, CAST(N'1988-07-03' AS Date), N'0786543210  ', N'CV0004@ptithcm.edu.vn', N'Đà Nẵng', N'Quận 4, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0005 ', N'Huỳnh Văn Tâm', N'CB2   ', 1, CAST(N'1991-09-18' AS Date), N'0456789012  ', N'CV0005@ptithcm.edu.vn', N'Cần Thơ', N'Quận 5, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0006 ', N'Võ Thị Bích', N'CB2   ', 0, CAST(N'1986-12-24' AS Date), N'0234567890  ', N'CV0006@ptithcm.edu.vn', N'Vĩnh Long', N'Quận 6, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0007 ', N'Đặng Minh Tuấn', N'CB2   ', 1, CAST(N'1993-04-05' AS Date), N'0890123456  ', N'CV0007@ptithcm.edu.vn', N'Thái Bình', N'Quận 7, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0008 ', N'Trương Thị Hoa', N'CB2   ', 0, CAST(N'1987-07-15' AS Date), N'0678901234  ', N'CV0008@ptithcm.edu.vn', N'An Giang', N'Quận 8, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0009 ', N'Lâm Văn Sơn', N'CB2   ', 1, CAST(N'1984-11-30' AS Date), N'0321456987  ', N'CV0009@ptithcm.edu.vn', N'Bình Dương', N'Quận 9, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0010 ', N'Nguyễn Thị Kim', N'CB2   ', 0, CAST(N'1989-02-14' AS Date), N'0789541236  ', N'CV0010@ptithcm.edu.vn', N'Tây Ninh', N'Quận 10, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0011 ', N'Phan Văn Bình', N'CB2   ', 1, CAST(N'1986-08-21' AS Date), N'0345987651  ', N'CV0011@ptithcm.edu.vn', N'Thanh Hóa', N'Quận 11, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0012 ', N'Vũ Thị Ngọc', N'CB2   ', 0, CAST(N'1995-02-28' AS Date), N'0958741236  ', N'CV0012@ptithcm.edu.vn', N'Nghệ An', N'Quận 12, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0013 ', N'Lý Thành Đạt', N'CB2   ', 1, CAST(N'1984-11-07' AS Date), N'0671234598  ', N'CV0013@ptithcm.edu.vn', N'Quảng Ninh', N'Quận Gò Vấp, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0014 ', N'Ngô Thị Huệ', N'CB2   ', 0, CAST(N'1989-10-19' AS Date), N'0213459876  ', N'CV0014@ptithcm.edu.vn', N'Phú Yên', N'Quận Bình Thạnh, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0015 ', N'Tạ Minh Châu', N'CB2   ', 1, CAST(N'1992-05-13' AS Date), N'0654897312  ', N'CV0015@ptithcm.edu.vn', N'Bạc Liêu', N'Quận Phú Nhuận, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0016 ', N'Lê Thị Mai', N'CB2   ', 0, CAST(N'1987-09-26' AS Date), N'0458712369  ', N'CV0016@ptithcm.edu.vn', N'Cà Mau', N'Quận Tân Bình, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0017 ', N'Hồ Minh Phước', N'CB2   ', 1, CAST(N'1990-12-05' AS Date), N'0321456987  ', N'CV0017@ptithcm.edu.vn', N'Bến Tre', N'Quận Tân Phú, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0018 ', N'Đinh Văn Anh', N'CB2   ', 0, CAST(N'1985-03-18' AS Date), N'0789654123  ', N'CV0018@ptithcm.edu.vn', N'Bình Phước', N'Huyện Củ Chi, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0019 ', N'Trần Thị Thúy', N'CB2   ', 1, CAST(N'1988-06-24' AS Date), N'0932147856  ', N'CV0019@ptithcm.edu.vn', N'Long An', N'Huyện Hóc Môn, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0020 ', N'Võ Văn Đức', N'CB2   ', 0, CAST(N'1991-01-30' AS Date), N'0983652147  ', N'CV0020@ptithcm.edu.vn', N'Đồng Nai', N'Huyện Nhà Bè, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0021 ', N'Hoàng Thị Hồng', N'CNTT2 ', 1, CAST(N'1986-07-17' AS Date), N'0569871234  ', N'CV0021@ptithcm.edu.vn', N'Hà Tĩnh', N'Thành phố Thủ Đức, TP Hồ Chí Minh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0022 ', N'Nguyễn Văn Tú', N'CNTT2 ', 0, CAST(N'1994-09-10' AS Date), N'0321456987  ', N'CV0022@ptithcm.edu.vn', N'Hà Nam', N'Thành phố Biên Hòa, Đồng Nai')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0023 ', N'Trần Thị Lý', N'CNTT2 ', 1, CAST(N'1983-02-28' AS Date), N'0789546213  ', N'CV0023@ptithcm.edu.vn', N'Thái Nguyên', N'Thành phố Vũng Tàu, Bà Rịa - Vũng Tàu')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0024 ', N'Lê Văn Quân', N'CNTT2 ', 0, CAST(N'1988-05-07' AS Date), N'0945678123  ', N'CV0024@ptithcm.edu.vn', N'Hà Nam', N'Thành phố Thanh Hóa, Thanh Hóa')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0025 ', N'Phạm Thị Trang', N'CNTT2 ', 1, CAST(N'1991-10-15' AS Date), N'0369852147  ', N'CV0025@ptithcm.edu.vn', N'Thừa Thiên Huế', N'Thành phố Huế, Thừa Thiên Huế')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0026 ', N'Hoàng Văn Tín', N'CNTT2 ', 0, CAST(N'1987-03-21' AS Date), N'0894563210  ', N'CV0026@ptithcm.edu.vn', N'Vĩnh Long', N'Thành phố Cần Thơ, Cần Thơ')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0027 ', N'Đỗ Thị Thanh', N'CNTT2 ', 1, CAST(N'1993-08-30' AS Date), N'0769854123  ', N'CV0027@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Bà Rịa, Bà Rịa - Vũng Tàu')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0028 ', N'Nguyễn Văn Long', N'CNTT2 ', 0, CAST(N'1984-11-17' AS Date), N'0932145678  ', N'CV0028@ptithcm.edu.vn', N'Lâm Đồng', N'Thành phố Đà Lạt, Lâm Đồng')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0029 ', N'Trần Thị Hà', N'CNTT2 ', 1, CAST(N'1989-04-08' AS Date), N'0678954321  ', N'CV0029@ptithcm.edu.vn', N'Quảng Nam', N'Thành phố Tam Kỳ, Quảng Nam')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0030 ', N'Lê Văn Tùng', N'CNTT2 ', 0, CAST(N'1986-01-22' AS Date), N'0563147890  ', N'CV0030@ptithcm.edu.vn', N'Bạc Liêu', N'Thành phố Cà Mau, Cà Mau')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0031 ', N'Trần Văn Đạt', N'CNTT2 ', 1, CAST(N'1987-11-12' AS Date), N'0456987412  ', N'CV0031@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận 1')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0032 ', N'Lê Thị Thùy', N'CNTT2 ', 0, CAST(N'1990-05-25' AS Date), N'0896543210  ', N'CV0032@ptithcm.edu.vn', N'Long An', N'Thành phố Hồ Chí Minh, Quận 2')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0033 ', N'Phạm Văn Bình', N'CNTT2 ', 1, CAST(N'1986-03-17' AS Date), N'0369852147  ', N'CV0033@ptithcm.edu.vn', N'Nghệ An', N'Thành phố Hồ Chí Minh, Quận 3')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0034 ', N'Nguyễn Thị Lan', N'CNTT2 ', 0, CAST(N'1991-08-20' AS Date), N'0789456123  ', N'CV0034@ptithcm.edu.vn', N'Hà Nội', N'Thành phố Hồ Chí Minh, Quận 4')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0035 ', N'Huỳnh Văn Tân', N'CNTT2 ', 1, CAST(N'1984-09-08' AS Date), N'0956874123  ', N'CV0035@ptithcm.edu.vn', N'An Giang', N'Thành phố Hồ Chí Minh, Quận 5')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0036 ', N'Lê Thị Ngọc', N'CNTT2 ', 0, CAST(N'1989-06-13' AS Date), N'0231456987  ', N'CV0036@ptithcm.edu.vn', N'Kiên Giang', N'Thành phố Hồ Chí Minh, Quận 6')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0037 ', N'Trần Văn Tú', N'CNTT2 ', 1, CAST(N'1992-02-07' AS Date), N'0365987412  ', N'CV0037@ptithcm.edu.vn', N'Tiền Giang', N'Thành phố Hồ Chí Minh, Quận 7')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0038 ', N'Nguyễn Thị Ngọc', N'CNTT2 ', 0, CAST(N'1985-04-30' AS Date), N'0981456321  ', N'CV0038@ptithcm.edu.vn', N'Vĩnh Long', N'Thành phố Hồ Chí Minh, Quận 8')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0039 ', N'Phan Văn Trung', N'CNTT2 ', 1, CAST(N'1990-10-03' AS Date), N'0569874123  ', N'CV0039@ptithcm.edu.vn', N'Cần Thơ', N'Thành phố Hồ Chí Minh, Quận 9')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0040 ', N'Đỗ Thị Hồng', N'CNTT2 ', 0, CAST(N'1987-12-18' AS Date), N'0765981234  ', N'CV0040@ptithcm.edu.vn', N'Lâm Đồng', N'Thành phố Hồ Chí Minh, Quận 10')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0041 ', N'Lê Văn Tuấn', N'CNTT2 ', 1, CAST(N'1984-03-21' AS Date), N'0456987231  ', N'CV0041@ptithcm.edu.vn', N'Thừa Thiên Huế', N'Thành phố Hồ Chí Minh, Quận 11')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0042 ', N'Trần Thị Hằng', N'CNTT2 ', 0, CAST(N'1991-09-14' AS Date), N'0984567123  ', N'CV0042@ptithcm.edu.vn', N'Quảng Trị', N'Thành phố Hồ Chí Minh, Quận 12')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0043 ', N'Lý Thị Hương', N'CNTT2 ', 1, CAST(N'1986-11-27' AS Date), N'0325981476  ', N'CV0043@ptithcm.edu.vn', N'Quảng Bình', N'Thành phố Hồ Chí Minh, Quận Gò Vấp')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0044 ', N'Nguyễn Văn Minh', N'CNTT2 ', 0, CAST(N'1989-05-10' AS Date), N'0769854123  ', N'CV0044@ptithcm.edu.vn', N'Quảng Ngãi', N'Thành phố Hồ Chí Minh, Quận Bình Thạnh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0045 ', N'Trương Thị Hoa', N'CNTT2 ', 1, CAST(N'1992-01-04' AS Date), N'0896541237  ', N'CV0045@ptithcm.edu.vn', N'Phú Yên', N'Thành phố Hồ Chí Minh, Quận Tân Bình')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0046 ', N'Đặng Văn Quân', N'CNTT2 ', 0, CAST(N'1988-04-27' AS Date), N'0369852147  ', N'CV0046@ptithcm.edu.vn', N'Hà Tĩnh', N'Thành phố Hồ Chí Minh, Quận Tân Phú')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0047 ', N'Lê Thị Hà', N'CNTT2 ', 1, CAST(N'1993-07-15' AS Date), N'0987456321  ', N'CV0047@ptithcm.edu.vn', N'Thanh Hóa', N'Thành phố Hồ Chí Minh, Quận Phú Nhuận')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0048 ', N'Hoàng Văn Đạt', N'CNTT2 ', 0, CAST(N'1985-10-28' AS Date), N'0769854123  ', N'CV0048@ptithcm.edu.vn', N'Ninh Bình', N'Thành phố Hồ Chí Minh, Quận Bình Tân')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0049 ', N'Vũ Thị Lan', N'CNTT2 ', 1, CAST(N'1990-12-07' AS Date), N'0897456321  ', N'CV0049@ptithcm.edu.vn', N'Thái Bình', N'Thành phố Hồ Chí Minh, Huyện Củ Chi')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0050 ', N'Đỗ Văn Phong', N'CNTT2 ', 0, CAST(N'1986-08-19' AS Date), N'0321456987  ', N'CV0050@ptithcm.edu.vn', N'Nghệ An', N'Thành phố Hồ Chí Minh, Huyện Hóc Môn')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0051 ', N'Nguyễn Thị Ngọc', N'KTDT2 ', 1, CAST(N'1991-03-02' AS Date), N'0987456213  ', N'CV0051@ptithcm.edu.vn', N'Quảng Trị', N'Thành phố Hồ Chí Minh, Huyện Bình Chánh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0052 ', N'Trần Văn Tú', N'KTDT2 ', 0, CAST(N'1984-06-13' AS Date), N'0325981476  ', N'CV0052@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Huyện Nhà Bè')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0053 ', N'Phạm Thị Huệ', N'KTDT2 ', 1, CAST(N'1989-09-24' AS Date), N'0769854123  ', N'CV0053@ptithcm.edu.vn', N'Quảng Nam', N'Thành phố Hồ Chí Minh, Huyện Cần Giờ')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0054 ', N'Đinh Văn Tân', N'KTDT2 ', 0, CAST(N'1986-01-11' AS Date), N'0987456321  ', N'CV0054@ptithcm.edu.vn', N'Thái Nguyên', N'Thành phố Hồ Chí Minh, Quận 1')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0055 ', N'Lê Thị Hồng', N'KTDT2 ', 1, CAST(N'1992-04-02' AS Date), N'0325981476  ', N'CV0055@ptithcm.edu.vn', N'Hải Phòng', N'Thành phố Hồ Chí Minh, Quận 2')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0056 ', N'Hoàng Văn Thành', N'KTDT2 ', 0, CAST(N'1987-07-25' AS Date), N'0769854123  ', N'CV0056@ptithcm.edu.vn', N'Hải Dương', N'Thành phố Hồ Chí Minh, Quận 3')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0057 ', N'Nguyễn Thị Nhung', N'KTDT2 ', 1, CAST(N'1990-02-14' AS Date), N'0987456321  ', N'CV0057@ptithcm.edu.vn', N'Bình Dương', N'Thành phố Hồ Chí Minh, Quận 4')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0058 ', N'Lê Văn Hải', N'KTDT2 ', 0, CAST(N'1987-05-27' AS Date), N'0765984123  ', N'CV0058@ptithcm.edu.vn', N'Bà Rịa - Vũng Tàu', N'Thành phố Hồ Chí Minh, Quận 5')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0059 ', N'Nguyễn Thị Thùy', N'KTDT2 ', 1, CAST(N'1984-08-09' AS Date), N'0325981476  ', N'CV0059@ptithcm.edu.vn', N'Đồng Tháp', N'Thành phố Hồ Chí Minh, Quận 6')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0060 ', N'Phạm Văn Tú', N'KTDT2 ', 0, CAST(N'1989-11-20' AS Date), N'0987456321  ', N'CV0060@ptithcm.edu.vn', N'Cà Mau', N'Thành phố Hồ Chí Minh, Quận 7')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0061 ', N'Hoàng Thị Lan', N'KTDT2 ', 1, CAST(N'1992-03-03' AS Date), N'0569857412  ', N'CV0061@ptithcm.edu.vn', N'An Giang', N'Thành phố Hồ Chí Minh, Quận 8')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0062 ', N'Trần Văn Tân', N'KTDT2 ', 0, CAST(N'1985-06-16' AS Date), N'0325981476  ', N'CV0062@ptithcm.edu.vn', N'Bạc Liêu', N'Thành phố Hồ Chí Minh, Quận 9')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0063 ', N'Nguyễn Thị Ngọc', N'KTDT2 ', 1, CAST(N'1991-09-29' AS Date), N'0987456321  ', N'CV0063@ptithcm.edu.vn', N'Thái Bình', N'Thành phố Hồ Chí Minh, Quận 10')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0064 ', N'Lê Văn Dương', N'KTDT2 ', 0, CAST(N'1986-12-12' AS Date), N'0769854123  ', N'CV0064@ptithcm.edu.vn', N'Ninh Thuận', N'Thành phố Hồ Chí Minh, Quận 11')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0065 ', N'Hoàng Thị Mai', N'KTDT2 ', 1, CAST(N'1990-01-25' AS Date), N'0321456987  ', N'CV0065@ptithcm.edu.vn', N'Lạng Sơn', N'Thành phố Hồ Chí Minh, Quận 12')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0066 ', N'Trần Văn Phúc', N'KTDT2 ', 0, CAST(N'1987-04-18' AS Date), N'0987456321  ', N'CV0066@ptithcm.edu.vn', N'Quảng Ngãi', N'Thành phố Hồ Chí Minh, Quận Gò Vấp')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0067 ', N'Nguyễn Thị Thúy', N'KTDT2 ', 1, CAST(N'1984-07-21' AS Date), N'0769854123  ', N'CV0067@ptithcm.edu.vn', N'Phú Thọ', N'Thành phố Hồ Chí Minh, Quận Bình Thạnh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0068 ', N'Trần Văn Toàn', N'KTDT2 ', 0, CAST(N'1992-10-14' AS Date), N'0321456987  ', N'CV0068@ptithcm.edu.vn', N'Thanh Hóa', N'Thành phố Hồ Chí Minh, Quận Tân Bình')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0069 ', N'Lê Thị Thanh', N'KTDT2 ', 1, CAST(N'1985-01-27' AS Date), N'0987456321  ', N'CV0069@ptithcm.edu.vn', N'Thái Nguyên', N'Thành phố Hồ Chí Minh, Quận Tân Phú')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0070 ', N'Phạm Văn Đức', N'KTDT2 ', 0, CAST(N'1990-04-20' AS Date), N'0769854123  ', N'CV0070@ptithcm.edu.vn', N'Quảng Bình', N'Thành phố Hồ Chí Minh, Quận Phú Nhuận')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0071 ', N'Hoàng Thị Hạnh', N'QTKD2 ', 1, CAST(N'1987-07-03' AS Date), N'0321456987  ', N'CV0071@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận Bình Tân')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0072 ', N'Lê Văn Đức', N'QTKD2 ', 0, CAST(N'1984-09-26' AS Date), N'0987456321  ', N'CV0072@ptithcm.edu.vn', N'Long An', N'Thành phố Hồ Chí Minh, Quận Tân Phú')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0073 ', N'Phạm Thị Ngọc', N'QTKD2 ', 1, CAST(N'1991-12-09' AS Date), N'0769854123  ', N'CV0073@ptithcm.edu.vn', N'Vĩnh Long', N'Thành phố Hồ Chí Minh, Quận Bình Chánh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0074 ', N'Nguyễn Văn Tú', N'QTKD2 ', 0, CAST(N'1986-03-22' AS Date), N'0321456987  ', N'CV0074@ptithcm.edu.vn', N'Thừa Thiên Huế', N'Thành phố Hồ Chí Minh, Quận Nhà Bè')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0075 ', N'Trần Thị Thúy', N'QTKD2 ', 1, CAST(N'1990-06-15' AS Date), N'0987456321  ', N'CV0075@ptithcm.edu.vn', N'Hà Tĩnh', N'Thành phố Hồ Chí Minh, Huyện Cần Giờ')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0076 ', N'Hoàng Văn Đạt', N'QTKD2 ', 0, CAST(N'1987-09-28' AS Date), N'0769854123  ', N'CV0076@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Huyện Củ Chi')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0077 ', N'Lê Thị Lan', N'QTKD2 ', 1, CAST(N'1984-12-11' AS Date), N'0321456987  ', N'CV0077@ptithcm.edu.vn', N'Thái Nguyên', N'Thành phố Hồ Chí Minh, Huyện Hóc Môn')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0078 ', N'Trần Văn Phúc', N'QTKD2 ', 0, CAST(N'1992-03-04' AS Date), N'0987456321  ', N'CV0078@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Huyện Bình Chánh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0079 ', N'Nguyễn Thị Hải', N'QTKD2 ', 1, CAST(N'1985-05-17' AS Date), N'0769854123  ', N'CV0079@ptithcm.edu.vn', N'Cà Mau', N'Thành phố Hồ Chí Minh, Huyện Nhà Bè')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0080 ', N'Hoàng Văn Nam', N'QTKD2 ', 0, CAST(N'1990-08-30' AS Date), N'0321456987  ', N'CV0080@ptithcm.edu.vn', N'Đồng Nai', N'Thành phố Hồ Chí Minh, Huyện Cần Giờ')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0081 ', N'Trần Văn An', N'QTKD2 ', 1, CAST(N'1990-03-20' AS Date), N'0987456321  ', N'CV0081@ptithcm.edu.vn', N'Đồng Nai', N'Thành phố Hồ Chí Minh, Quận 5')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0082 ', N'Lê Thị Bình', N'QTKD2 ', 0, CAST(N'1992-04-21' AS Date), N'0987456321  ', N'CV0082@ptithcm.edu.vn', N'Quảng Bình', N'Thành phố Hồ Chí Minh, Quận 6')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0083 ', N'Phạm Văn Cường', N'QTKD2 ', 1, CAST(N'1985-05-22' AS Date), N'0987456321  ', N'CV0083@ptithcm.edu.vn', N'Thái Nguyên', N'Thành phố Hồ Chí Minh, Quận 7')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0084 ', N'Hoàng Thị Dung', N'QTKD2 ', 0, CAST(N'1988-06-23' AS Date), N'0987456321  ', N'CV0084@ptithcm.edu.vn', N'Bà Rịa - Vũng Tàu', N'Thành phố Hồ Chí Minh, Quận 8')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0085 ', N'Lê Văn Đức', N'QTKD2 ', 1, CAST(N'1991-07-24' AS Date), N'0987456321  ', N'CV0085@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận 9')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0086 ', N'Nguyễn Thị Thơ', N'QTKD2 ', 0, CAST(N'1984-08-25' AS Date), N'0987456321  ', N'CV0086@ptithcm.edu.vn', N'Ninh Thuận', N'Thành phố Hồ Chí Minh, Quận 10')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0087 ', N'Võ Văn Bảo', N'QTKD2 ', 1, CAST(N'1990-09-26' AS Date), N'0987456321  ', N'CV0087@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận 11')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0088 ', N'Lý Thị Diệu', N'QTKD2 ', 0, CAST(N'1992-10-27' AS Date), N'0987456321  ', N'CV0088@ptithcm.edu.vn', N'Bình Dương', N'Thành phố Hồ Chí Minh, Quận 12')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0089 ', N'Nguyễn Văn Công', N'QTKD2 ', 1, CAST(N'1985-11-28' AS Date), N'0987456321  ', N'CV0089@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Quận Tân Bình')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0090 ', N'Trần Thị Mai', N'QTKD2 ', 0, CAST(N'1988-12-29' AS Date), N'0987456321  ', N'CV0090@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận Tân Phú')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0091 ', N'Phan Văn Đạt', N'VT2   ', 1, CAST(N'1991-01-30' AS Date), N'0987456321  ', N'CV0091@ptithcm.edu.vn', N'Bến Tre', N'Thành phố Hồ Chí Minh, Quận Gò Vấp')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0092 ', N'Nguyễn Thị Thanh', N'VT2   ', 0, CAST(N'1984-02-01' AS Date), N'0987456321  ', N'CV0092@ptithcm.edu.vn', N'Bình Dương', N'Thành phố Hồ Chí Minh, Quận Phú Nhuận')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0093 ', N'Lê Văn Dũng', N'VT2   ', 1, CAST(N'1990-03-02' AS Date), N'0987456321  ', N'CV0093@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận Bình Thạnh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0094 ', N'Võ Thị Lan', N'VT2   ', 0, CAST(N'1992-04-03' AS Date), N'0987456321  ', N'CV0094@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận Thủ Đức')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0095 ', N'Đặng Văn Tuấn', N'VT2   ', 1, CAST(N'1985-05-04' AS Date), N'0987456321  ', N'CV0095@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Quận 7')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0096 ', N'Nguyễn Thị Thảo', N'VT2   ', 0, CAST(N'1988-06-05' AS Date), N'0987456321  ', N'CV0096@ptithcm.edu.vn', N'Bến Tre', N'Thành phố Hồ Chí Minh, Quận 8')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0097 ', N'Lê Văn Đức', N'VT2   ', 1, CAST(N'1991-07-06' AS Date), N'0987456321  ', N'CV0097@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận 9')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0098 ', N'Phạm Thị Mai', N'VT2   ', 0, CAST(N'1984-08-07' AS Date), N'0987456321  ', N'CV0098@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận 10')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0099 ', N'Võ Văn Hoàng', N'VT2   ', 1, CAST(N'1990-09-08' AS Date), N'0987456321  ', N'CV0099@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Quận 11')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0100 ', N'Nguyễn Thị Lan', N'VT2   ', 0, CAST(N'1992-10-09' AS Date), N'0987456321  ', N'CV0100@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận 12')
GO
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0101 ', N'Hoàng Văn Đức', N'VT2   ', 1, CAST(N'1985-11-10' AS Date), N'0987456321  ', N'CV0101@ptithcm.edu.vn', N'Bến Tre', N'Thành phố Hồ Chí Minh, Quận Tân Bình')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0102 ', N'Lê Thị Hồng Len', N'VT2   ', 0, CAST(N'2003-11-27' AS Date), N'0987456321  ', N'CV0102@ptithcm.edu.vn', N'Phú Yên', N'Thành phố Hồ Chí Minh, Quận 5')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0103 ', N'Phan Văn Hải', N'VT2   ', 1, CAST(N'1991-01-12' AS Date), N'0987456321  ', N'CV0103@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Quận Gò Vấp')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0104 ', N'Lê Thị Hằng', N'VT2   ', 0, CAST(N'1992-02-13' AS Date), N'0987456321  ', N'CV0104@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận Phú Nhuận')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0105 ', N'Nguyễn Văn Hoa', N'VT2   ', 1, CAST(N'1985-03-14' AS Date), N'0987456321  ', N'CV0105@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận Bình Thạnh')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0106 ', N'Võ Thị Hồng', N'VT2   ', 0, CAST(N'1988-04-15' AS Date), N'0987456321  ', N'CV0106@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Quận Thủ Đức')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0107 ', N'Đặng Văn Hùng', N'VT2   ', 1, CAST(N'1991-05-16' AS Date), N'0987456321  ', N'CV0107@ptithcm.edu.vn', N'Bến Tre', N'Thành phố Hồ Chí Minh, Quận 7')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0108 ', N'Lê Thị Hương', N'VT2   ', 0, CAST(N'1984-06-17' AS Date), N'0987456321  ', N'CV0108@ptithcm.edu.vn', N'Bình Định', N'Thành phố Hồ Chí Minh, Quận 8')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0109 ', N'Phạm Văn Hùng', N'VT2   ', 1, CAST(N'1990-07-18' AS Date), N'0987456321  ', N'CV0109@ptithcm.edu.vn', N'Bình Thuận', N'Thành phố Hồ Chí Minh, Quận 9')
INSERT [dbo].[CoVan] ([MaCoVan], [TenCoVan], [Khoa], [GioiTinh], [NgaySinh], [Sdt], [Email], [QueQuan], [DiaChi]) VALUES (N'CV0110 ', N'Lê Thị Hường', N'VT2   ', 0, CAST(N'1985-08-19' AS Date), N'0987456321  ', N'CV0110@ptithcm.edu.vn', N'Bình Phước', N'Thành phố Hồ Chí Minh, Quận 10')
GO
INSERT [dbo].[DRLSV] ([MaDRL], [MSSV], [MaHK_NK], [DiemSV], [DiemCS], [DiemCV], [Ketqua], [TrangThai]) VALUES (N'DRL0001   ', N'N21DCAT001', N'TC0001', 3, 4, 5, N'5         ', NULL)
INSERT [dbo].[DRLSV] ([MaDRL], [MSSV], [MaHK_NK], [DiemSV], [DiemCS], [DiemCV], [Ketqua], [TrangThai]) VALUES (N'DRL0002   ', N'N21DCAT001', N'TC0002', NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2015-2016-1', 1, N'2015-2016', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2015-2016-2', 2, N'2015-2016', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2016-2017-1', 1, N'2016-2017', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2016-2017-2', 2, N'2016-2017', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2017-2018-1', 1, N'2017-2018', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2017-2018-2', 2, N'2017-2018', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2018-2019-1', 1, N'2018-2019', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2018-2019-2', 2, N'2018-2019', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2019-2020-1', 1, N'2019-2020', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2019-2020-2', 2, N'2019-2020', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2020-2021-1', 1, N'2020-2021', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2020-2021-2', 2, N'2020-2021', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2021-2022-1', 1, N'2021-2022', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2021-2022-2', 2, N'2021-2022', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2022-2023-1', 1, N'2022-2023', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2022-2023-2', 2, N'2022-2023', 0)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2023-2024-1', 1, N'2023-2024', 1)
INSERT [dbo].[HK_NK] ([MaHK_NK], [HocKy], [NienKhoa], [Xet]) VALUES (N'2023-2024-2', 2, N'2023-2024', 0)
GO
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'CB2   ', N'Cơ Bản II', CAST(N'1997-04-04' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'CNTT2 ', N'Công Nghệ Thông Tin II', CAST(N'1997-06-05' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'KTDT2 ', N'Kỹ Thuật Điện Tử II', CAST(N'1997-10-05' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'QTKD2 ', N'Quản Trị Kinh Doanh II', CAST(N'1997-05-06' AS Date))
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa], [NgayThanhLap]) VALUES (N'VT2   ', N'Viễn Thông II', CAST(N'1997-05-05' AS Date))
GO
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2015-2019', N'2015', N'2019', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2015-2020', N'2015', N'2020', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2016-2020', N'2016', N'2020', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2016-2021', N'2016', N'2021', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2017-2021', N'2017', N'2021', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2017-2022', N'2017', N'2022', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2018-2022', N'2018', N'2022', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2018-2023', N'2018', N'2023', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2019-2023', N'2019', N'2023', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2019-2024', N'2019', N'2024', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2020-2024', N'2020', N'2024', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2020-2025', N'2020', N'2025', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2021-2025', N'2021', N'2024', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2021-2026', N'2021', N'2026', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2022-2026', N'2022', N'2026', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2022-2027', N'2022', N'2027', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2023-2027', N'2023', N'2027', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2023-2028', N'2023', N'2028', 4.5)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2024-2028', N'2024', N'2028', 4)
INSERT [dbo].[KhoaHoc] ([MaKhoaHoc], [NamBD], [MamKT], [TGHoc]) VALUES (N'2024-2029', N'2024', N'2029', 4.5)
GO
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D15CQAT01-N', N'CNTT2 ', N'CV0039 ', N'2015-2020')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D15CQCN01-N', N'CNTT2 ', N'CV0022 ', N'2015-2020')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D15CQDT01-N', N'KTDT2 ', N'CV0060 ', N'2015-2020')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D15CQQT01-N', N'QTKD2 ', N'CV0071 ', N'2015-2020')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D15CQVT01-N', N'VT2   ', N'CV0103 ', N'2015-2020')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D16CQAT01-N', N'CNTT2 ', N'CV0024 ', N'2016-2021')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D16CQCN01-N', N'CNTT2 ', N'CV0021 ', N'2016-2021')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D16CQDT01-N', N'KTDT2 ', N'CV0062 ', N'2016-2021')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D16CQQT01-N', N'QTKD2 ', N'CV0076 ', N'2016-2021')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D16CQVT01-N', N'VT2   ', N'CV0091 ', N'2016-2021')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D17CQAT01-N', N'CNTT2 ', N'CV0038 ', N'2017-2022')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D17CQCN01-N', N'CNTT2 ', N'CV0044 ', N'2017-2022')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D17CQDT01-N', N'KTDT2 ', N'CV0069 ', N'2017-2022')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D17CQQT01-N', N'QTKD2 ', N'CV0085 ', N'2017-2022')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D17CQVT01-N', N'VT2   ', N'CV0096 ', N'2017-2022')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D18CQAT01-N', N'CNTT2 ', N'CV0048 ', N'2018-2023')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D18CQCN01-N', N'CNTT2 ', N'CV0021 ', N'2018-2023')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D18CQDT01-N', N'KTDT2 ', N'CV0070 ', N'2018-2023')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D18CQQT01-N', N'QTKD2 ', N'CV0071 ', N'2018-2023')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D18CQVT01-N', N'VT2   ', N'CV0097 ', N'2018-2023')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D19CQAT01-N', N'CNTT2 ', N'CV0041 ', N'2019-2024')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D19CQCN01-N', N'CNTT2 ', N'CV0026 ', N'2019-2024')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D19CQDT01-N', N'KTDT2 ', N'CV0061 ', N'2019-2024')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D19CQQT01-N', N'QTKD2 ', N'CV0086 ', N'2019-2024')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D19CQVT01-N', N'VT2   ', N'CV0095 ', N'2019-2024')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D20CQAT01-N', N'CNTT2 ', N'CV0021 ', N'2020-2025')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D20CQCN01-N', N'CNTT2 ', N'CV0033 ', N'2020-2025')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D20CQDT01-N', N'KTDT2 ', N'CV0066 ', N'2020-2025')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D20CQQT01-N', N'QTKD2 ', N'CV0087 ', N'2020-2025')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D20CQVT01-N', N'VT2   ', N'CV0092 ', N'2020-2025')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQAT01-N', N'CNTT2 ', N'CV0024 ', N'2021-2026')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQCN01-N', N'CNTT2 ', N'CV0039 ', N'2021-2026')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQDT01-N', N'KTDT2 ', N'CV0060 ', N'2021-2026')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQQT01-N', N'QTKD2 ', N'CV0088 ', N'2021-2026')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D21CQVT01-N', N'VT2   ', N'CV0109 ', N'2021-2026')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D22CQAT01-N', N'CNTT2 ', N'CV0025 ', N'2022-2027')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D22CQCN01-N', N'CNTT2 ', N'CV0030 ', N'2022-2027')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D22CQDT01-N', N'KTDT2 ', N'CV0055 ', N'2022-2027')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D22CQQT01-N', N'QTKD2 ', N'CV0074 ', N'2022-2027')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D22CQVT01-N', N'VT2   ', N'CV0099 ', N'2022-2027')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D23CQAT01-N', N'CNTT2 ', N'CV0026 ', N'2023-2028')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D23CQCN01-N', N'CNTT2 ', N'CV0049 ', N'2023-2028')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D23CQDT01-N', N'KTDT2 ', N'CV0068 ', N'2023-2028')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D23CQQT01-N', N'QTKD2 ', N'CV0087 ', N'2023-2028')
INSERT [dbo].[Lop] ([Lop], [MaKhoa], [MaCoVan], [MaKhoaHoc]) VALUES (N'D23CQVT01-N', N'VT2   ', N'CV0105 ', N'2023-2028')
GO
INSERT [dbo].[SinhVien] ([MSSV], [HoTen], [Lop], [ChucVu], [GioiTinh], [Sdt], [Email], [DiaChi], [QueQuan]) VALUES (N'N21DCAT001', N'Ngô Văn A', N'D21CQAT01-N', N'CV01', 1, N'0352752980  ', N'ngovana@gmail.com', N'Phú Yên', N'Phú Yên')
INSERT [dbo].[SinhVien] ([MSSV], [HoTen], [Lop], [ChucVu], [GioiTinh], [Sdt], [Email], [DiaChi], [QueQuan]) VALUES (N'N21DCCN001', N'Trần Thị C', N'D21CQCN01-N', N'CV04', 0, N'0736737873  ', N'tranthic@gmail.com', N'Phú Thọ', N'Phú Thọ')
GO
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCB2   ', N'CB2', N'12345678', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCNTT2 ', N'CNTT2', N'12345678', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0001', N'CV0001', N'12345678', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0002', N'CV0002', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0003', N'CV0003', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0004', N'CV0004', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0005', N'CV0005', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0006', N'CV0006', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0007', N'CV0007', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0008', N'CV0008', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0009', N'CV0009', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0010', N'CV0010', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0011', N'CV0011', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0012', N'CV0012', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0013', N'CV0013', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0014', N'CV0014', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0015', N'CV0015', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0016', N'CV0016', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0017', N'CV0017', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0018', N'CV0018', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0019', N'CV0019', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0020', N'CV0020', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0021', N'CV0021', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0022', N'CV0022', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0023', N'CV0023', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0024', N'CV0024', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0025', N'CV0025', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0026', N'CV0026', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0027', N'CV0027', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0028', N'CV0028', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0029', N'CV0029', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0030', N'CV0030', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0031', N'CV0031', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0032', N'CV0032', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0033', N'CV0033', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0034', N'CV0034', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0035', N'CV0035', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0036', N'CV0036', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0037', N'CV0037', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0038', N'CV0038', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0039', N'CV0039', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0040', N'CV0040', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0041', N'CV0041', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0042', N'CV0042', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0043', N'CV0043', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0044', N'CV0044', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0045', N'CV0045', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0046', N'CV0046', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0047', N'CV0047', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0048', N'CV0048', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0049', N'CV0049', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0050', N'CV0050', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0051', N'CV0051', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0052', N'CV0052', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0053', N'CV0053', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0054', N'CV0054', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0055', N'CV0055', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0056', N'CV0056', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0057', N'CV0057', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0058', N'CV0058', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0059', N'CV0059', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0060', N'CV0060', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0061', N'CV0061', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0062', N'CV0062', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0063', N'CV0063', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0064', N'CV0064', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0065', N'CV0065', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0066', N'CV0066', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0067', N'CV0067', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0068', N'CV0068', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0069', N'CV0069', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0070', N'CV0070', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0071', N'CV0071', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0072', N'CV0072', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0073', N'CV0073', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0074', N'CV0074', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0075', N'CV0075', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0076', N'CV0076', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0077', N'CV0077', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0078', N'CV0078', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0079', N'CV0079', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0080', N'CV0080', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0081', N'CV0081', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0082', N'CV0082', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0083', N'CV0083', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0084', N'CV0084', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0085', N'CV0085', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0086', N'CV0086', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0087', N'CV0087', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0088', N'CV0088', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0089', N'CV0089', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0090', N'CV0090', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0091', N'CV0091', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0092', N'CV0092', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0093', N'CV0093', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0094', N'CV0094', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0095', N'CV0095', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0096', N'CV0096', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0097', N'CV0097', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0098', N'CV0098', N'123456', N'covan')
GO
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0099', N'CV0099', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0100', N'CV0100', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0101', N'CV0101', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0102', N'CV0102', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0103', N'CV0103', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0104', N'CV0104', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0105', N'CV0105', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0106', N'CV0106', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0107', N'CV0107', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0108', N'CV0108', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0109', N'CV0109', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKCV0110', N'CV0110', N'123456', N'covan')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKKTDT2 ', N'KTDT2', N'12345678', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKQTKD2 ', N'QTKD2', N'12345678', N'khoa')
INSERT [dbo].[TaiKhoan] ([MaTK], [TenTK], [MatKhau], [LoaiTk]) VALUES (N'TKVT2   ', N'VT2', N'12345678', N'khoa')
GO
INSERT [dbo].[TBChamDiem] ([MaTB], [MaHK_NK], [NgayBD], [NgayKT_SV], [NgayKT_CS], [NgayKT_CV], [NgayKT_Khoa], [NgayCongBo]) VALUES (N'TB001', N'2023-2024-1', CAST(N'2024-04-30' AS Date), CAST(N'2024-05-05' AS Date), CAST(N'2024-05-10' AS Date), CAST(N'2024-05-15' AS Date), CAST(N'2024-05-20' AS Date), CAST(N'2024-05-25' AS Date))
GO
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC001', N'Ý thức và thái độ trong học tập', 3)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC002', N'Kết quả học tập trong kỳ học ', 10)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC003', N'Ý thức chấp hành tốt nội quy về các kỳ thi', 4)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC004', N'Ý thức và thái độ tham gia các hoạt động ngoại khóa, các sự kiện liên quan đến nghiên cứu khoa học, học thuật, chuyên môn, Câu lạc bộ (0,5 điểm/1 sự kiện, hoạt động tham gia, tổng điểm không vượt quá 2 điểm)', 2)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC005', N'Tinh thần vượt khó, phấn đấu vươn lên trong học tập (có ĐTBCTL học kỳ sau lớn hơn học kỳ trước đó; đối với sinh viên năm thứ nhất, học kỳ 1 không có điểm dưới 2,5)', 1)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC006', N'Thực hiện nghiêm túc các nội quy, quy chế, các quy định hiện hành trong Học viện.', 15)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC007', N'Thực hiện nghiệp túc các buổi họp lớp/ sinh hoạt đoàn thể do Học viện/Khoa/Viện, CVHT, Lớp/Chi đoàn tổ chức (tùy thuộc vào số buổi tổ chức sinh hoạt, họp)', 5)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC008', N'Tham gia các buổi hội thảo việc làm, định hướng nghề nghiệp do Học viện tổ chức (1 điểm/1 sự kiện tham gia, tổng điểm không vượt quá 5 điểm)', 5)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC009', N'Tham gia đầy đủ các hoạt động chính trị, xã hội, các hoạt động văn hóa, văn nghệ, thể thao, phong trào tình nguyện, các buổi sinh hoạt chuyên đề do Học viện, lớp/chi đoàn, địa phương nơi cư trú  tổ chức  (2 điểm/1 hoạt động, tổng điểm không vượt quá 10 điểm)', 10)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC010', N'Tham gia công tác xã hội như: hiến máu nhân đạo, ủng hộ người nghèo gặp thiên tai lũ lụt và các công tác xã hội khác (1 điểm/1 hoạt động tham gia, tổng điểm không vượt quá 4 điểm)', 4)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC011', N'Tuyên truyền tích cực hình ảnh về Trường/Khoa trên các trang mạng xã hội (1 điểm/1 hoạt động, tổng điểm không vượt quá 3 điểm)', 3)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC012', N'Tích cực tham gia các hoạt động phòng, chống tội phạm, các tệ nạn xã hội, phát hiện và báo cáo kịp thời những hành vi có liên quan đến ma túy, các tệ nạn xã hội khác', 3)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC013', N'Đưa các thông tin sai lệch, thông tin chưa được kiểm chứng, đăng bình luận không chính xác, thiếu tích cực về Học viện/ Khoa/ ngành đang học.', -10)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC014', N'Chấp hành nghiêm chỉnh chủ trương của Đảng, chính sách, pháp luật của Nhà nước, Học viện và của địa phương nơi cư trú', 8)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC015', N'Tích cực tham gia tuyên truyền chủ trương của Đảng, chính sách, pháp luật của Nhà nước, Học viện  và quy định của địa phương nơi cư trú; có ý thức thực hiện giữ gìn vệ sinh chung', 5)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC016', N'Có mối quan hệ đúng mực với Thầy/ Cô, cán bộ, nhân viên Học viện', 5)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC017', N' Có mối quan hệ tốt với bạn bè trong lớp và mọi người xung quanh; có tinh thần đoàn kết, chia sẻ, giúp đỡ nhau trong học tập và các vấn đề khác trong cộng đồng', 5)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC018', N'Được biểu dương khen thưởng trong các hoạt động liên quan đến ý thức công dân trong quan hệ cộng đồng', 2)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC019', N'Vi phạm an ninh, trật tự xã hội; an toàn giao thông (có giấy báo của các cơ quan hữu quan)', -5)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC020', N'Sinh viên được Học viện phân công làm lớp trưởng, lớp phó; bí thư, phó bí thư chi đoàn, BCH đoàn Học viện/khoa; BCH Hội sinh viên Học viện/khoa; chủ nhiệm, phó chủ nhiệm các các Câu lạc bộ, đội nhóm trực thuộc Học viện/khoa được tập thể sinh viên và đơn vị quản lý ghi nhận hoàn thành nhiệm vụ. ', 4)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC021', N'Thành viên tham gia các Câu lạc bộ, đội nhóm trực thuộc Học viện /khoa được tập thể sinh viên và đơn vị quản lý ghi nhận hoàn thành tốt nhiệm vụ; sinh viên tham gia tổ chức các chương trình, là cộng tác viên tham gia tích cực vào các hoạt động chung cấp Học viện, khoa.', 3)
INSERT [dbo].[TieuChiDanhGia] ([MaTieuChi], [NoiDung], [DiemQD]) VALUES (N'TC022', N'Sinh viên đạt thành tích đặc biệt trong học tập, rèn luyện', 3)
GO
USE [master]
GO
ALTER DATABASE [QLDRL] SET  READ_WRITE 
GO
