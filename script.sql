USE [master]
GO
/****** Object:  Database [QLDRL]    Script Date: 4/29/2024 11:40:03 AM ******/
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
/****** Object:  Table [dbo].[ChucVu]    Script Date: 4/29/2024 11:40:03 AM ******/
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
/****** Object:  Table [dbo].[CoVan]    Script Date: 4/29/2024 11:40:03 AM ******/
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
	[Email] [nvarchar](50) NULL,
	[QueQuan] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_CoVan] PRIMARY KEY CLUSTERED 
(
	[MaCoVan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DRL]    Script Date: 4/29/2024 11:40:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DRL](
	[MaDRL] [nchar](10) NOT NULL,
	[MSSV] [nchar](10) NOT NULL,
	[MaHK_NK] [nchar](11) NOT NULL,
	[MaTieuChi] [nchar](5) NOT NULL,
	[DiemSV] [int] NULL,
	[DiemCS] [int] NULL,
	[DiemCV] [int] NULL,
	[DiemDuyet] [int] NULL,
 CONSTRAINT [PK_DRL] PRIMARY KEY CLUSTERED 
(
	[MaDRL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HK_NK]    Script Date: 4/29/2024 11:40:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HK_NK](
	[MaHK_NK] [nchar](11) NOT NULL,
	[HocKy] [int] NULL,
	[NienKhoa] [nchar](9) NULL,
 CONSTRAINT [PK_HK_NK] PRIMARY KEY CLUSTERED 
(
	[MaHK_NK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 4/29/2024 11:40:03 AM ******/
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
/****** Object:  Table [dbo].[Lop]    Script Date: 4/29/2024 11:40:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lop](
	[Lop] [nchar](11) NOT NULL,
	[MaKhoa] [nchar](6) NOT NULL,
	[MaCoVan] [nchar](7) NOT NULL,
 CONSTRAINT [PK_Lop] PRIMARY KEY CLUSTERED 
(
	[Lop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 4/29/2024 11:40:03 AM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 4/29/2024 11:40:03 AM ******/
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
/****** Object:  Table [dbo].[ThongBao]    Script Date: 4/29/2024 11:40:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongBao](
	[MaTB] [nchar](5) NOT NULL,
	[MaHK_NK] [nchar](11) NOT NULL,
	[NgayBD] [date] NULL,
	[NgayKT_SV] [date] NULL,
	[NgayKT_CS] [date] NULL,
	[NgayKT_CV] [date] NULL,
	[NgayKT_Khoa] [date] NULL,
	[NgayKT] [date] NULL,
 CONSTRAINT [PK_ThongBao] PRIMARY KEY CLUSTERED 
(
	[MaTB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TieuChiDanhGia]    Script Date: 4/29/2024 11:40:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TieuChiDanhGia](
	[MaTieuChi] [nchar](5) NOT NULL,
	[NoiDung] [nvarchar](200) NULL,
	[DiemToiDa] [int] NULL,
 CONSTRAINT [PK_TieuChiDanhGia] PRIMARY KEY CLUSTERED 
(
	[MaTieuChi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrangThai]    Script Date: 4/29/2024 11:40:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrangThai](
	[MaTrangThai] [nchar](12) NOT NULL,
	[MaHK_NK] [nchar](11) NOT NULL,
	[MSSV] [nchar](10) NOT NULL,
	[TrangThai] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_TrangThai] PRIMARY KEY CLUSTERED 
(
	[MaTrangThai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [QLDRL] SET  READ_WRITE 
GO
