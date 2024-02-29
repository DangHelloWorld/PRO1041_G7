USE [master]
GO
/****** Object:  Database [PRO1041_G7_V8]    Script Date: 2/29/2024 10:28:34 AM ******/
CREATE DATABASE [PRO1041_G7_V8]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRO1041_G7_V8', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\PRO1041_G7_V8.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PRO1041_G7_V8_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\PRO1041_G7_V8_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PRO1041_G7_V8] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRO1041_G7_V8].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRO1041_G7_V8] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PRO1041_G7_V8] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRO1041_G7_V8] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRO1041_G7_V8] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PRO1041_G7_V8] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRO1041_G7_V8] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PRO1041_G7_V8] SET  MULTI_USER 
GO
ALTER DATABASE [PRO1041_G7_V8] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRO1041_G7_V8] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRO1041_G7_V8] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRO1041_G7_V8] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PRO1041_G7_V8] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PRO1041_G7_V8] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [PRO1041_G7_V8] SET QUERY_STORE = OFF
GO
USE [PRO1041_G7_V8]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenChatLieu] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdSanPham] [int] NULL,
	[IdKichCo] [int] NULL,
	[IdMauSac] [int] NULL,
	[IdHinhAnh] [int] NULL,
	[MaSanPham] [varchar](20) NULL,
	[GiaBan] [decimal](20, 0) NULL,
	[SoLuong] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ChucVu] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhAnh]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhAnh](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenHinhAnh] [nvarchar](30) NULL,
	[HinhAnh] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdNhanVien] [int] NULL,
	[IdKhachHang] [int] NULL,
	[IdKhuyenMai] [int] NULL,
	[IdPhuocThucThanhToan] [int] NULL,
	[MaHD] [varchar](20) NULL,
	[NgayTao] [datetime2](7) NULL,
	[NgayThanhToan] [datetime2](7) NULL,
	[TongTien] [decimal](20, 0) NULL,
	[SoTienDuocGiam] [decimal](20, 0) NULL,
	[GhiChu] [text] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdHoaDon] [int] NULL,
	[IdCTSanPham] [int] NULL,
	[SoLuong] [int] NULL,
	[DonGia] [decimal](20, 0) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MaKhachHang] [varchar](20) NULL,
	[TenKhachHang] [nvarchar](30) NULL,
	[SoDienThoai] [varchar](30) NULL,
	[NgayTao] [datetime2](7) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenKhuyenMai] [nvarchar](30) NULL,
	[MoTa] [text] NULL,
	[SoLuong] [int] NULL,
	[KieuGiamGia] [bit] NULL,
	[MucGiamGia] [float] NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichCo]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichCo](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[KichCo] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenMauSac] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](30) NULL,
	[GioiTinh] [int] NULL,
	[NgaySinh] [date] NULL,
	[SoDienThoai] [varchar](30) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Email] [varchar](50) NULL,
	[NgayTao] [datetime2](7) NULL,
	[MatKhau] [varchar](64) NULL,
	[IdChucVU] [int] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenNSX] [nvarchar](30) NULL,
	[SoDienThoai] [varchar](30) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[Email] [varchar](50) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuongThucThanhToan]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuongThucThanhToan](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenPhuongThuc] [nvarchar](30) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 2/29/2024 10:28:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TenSanPham] [nvarchar](30) NULL,
	[IdDanhMuc] [int] NULL,
	[IdChatLieu] [int] NULL,
	[IdNSX] [int] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 
GO
INSERT [dbo].[ChucVu] ([Id], [ChucVu], [TrangThai]) VALUES (1, N'Quản lý', 1)
GO
INSERT [dbo].[ChucVu] ([Id], [ChucVu], [TrangThai]) VALUES (2, N'Nhân Viên', 1)
GO
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 
GO
INSERT [dbo].[KhachHang] ([Id], [MaKhachHang], [TenKhachHang], [SoDienThoai], [NgayTao], [TrangThai]) VALUES (1, N'KH001', N'Khách váng lai', N'0918231232', CAST(N'2024-02-29T00:00:00.0000000' AS DateTime2), 1)
GO
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 
GO
INSERT [dbo].[NhanVien] ([Id], [TenNhanVien], [GioiTinh], [NgaySinh], [SoDienThoai], [DiaChi], [Email], [NgayTao], [MatKhau], [IdChucVU], [TrangThai]) VALUES (1, N'Nguyễn Bá Đăng', 1, CAST(N'2003-01-06' AS Date), N'0961057585', N'Bac Ninh', N'abc123', CAST(N'2024-02-29T10:19:57.8366667' AS DateTime2), N'123456', 1, 1)
GO
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ChiTietS__FAC7442C5AE9C82A]    Script Date: 2/29/2024 10:28:34 AM ******/
ALTER TABLE [dbo].[ChiTietSanPham] ADD UNIQUE NONCLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HoaDon__2725A6E103BE7D6F]    Script Date: 2/29/2024 10:28:34 AM ******/
ALTER TABLE [dbo].[HoaDon] ADD UNIQUE NONCLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhachHan__88D2F0E40E8B7359]    Script Date: 2/29/2024 10:28:34 AM ******/
ALTER TABLE [dbo].[KhachHang] ADD UNIQUE NONCLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  DEFAULT (NULL) FOR [TenChatLieu]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [IdSanPham]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [IdKichCo]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [IdMauSac]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [IdHinhAnh]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT ((0)) FOR [GiaBan]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT ((0)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [MoTa]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (NULL) FOR [ChucVu]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  DEFAULT (NULL) FOR [TenDanhMuc]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HinhAnh] ADD  DEFAULT (NULL) FOR [TenHinhAnh]
GO
ALTER TABLE [dbo].[HinhAnh] ADD  DEFAULT (NULL) FOR [HinhAnh]
GO
ALTER TABLE [dbo].[HinhAnh] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [IdNhanVien]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [IdKhachHang]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [IdKhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [IdPhuocThucThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayThanhToan]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [TongTien]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [SoTienDuocGiam]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [GhiChu]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT (NULL) FOR [IdHoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT (NULL) FOR [IdCTSanPham]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((0)) FOR [SoLuong]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((0)) FOR [DonGia]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [TenKhachHang]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [SoDienThoai]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [TenKhuyenMai]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [MoTa]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [MucGiamGia]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [NgayBatDau]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [NgayKetThuc]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KichCo] ADD  DEFAULT (NULL) FOR [KichCo]
GO
ALTER TABLE [dbo].[KichCo] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (NULL) FOR [TenMauSac]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [TenNhanVien]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [SoDienThoai]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [Email]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [MatKhau]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [IdChucVU]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (NULL) FOR [TenNSX]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (NULL) FOR [SoDienThoai]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT (NULL) FOR [Email]
GO
ALTER TABLE [dbo].[NSX] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[PhuongThucThanhToan] ADD  DEFAULT (NULL) FOR [TenPhuongThuc]
GO
ALTER TABLE [dbo].[PhuongThucThanhToan] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [TenSanPham]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [IdDanhMuc]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [IdChatLieu]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [IdNSX]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdHinhAnh])
REFERENCES [dbo].[HinhAnh] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdKichCo])
REFERENCES [dbo].[KichCo] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKhachHang])
REFERENCES [dbo].[KhachHang] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdNhanVien])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([IdPhuocThucThanhToan])
REFERENCES [dbo].[PhuongThucThanhToan] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdCTSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([Id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdHoaDon])
REFERENCES [dbo].[HoaDon] ([Id])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([IdChucVU])
REFERENCES [dbo].[ChucVu] ([Id])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IdChatLieu])
REFERENCES [dbo].[ChatLieu] ([Id])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IdDanhMuc])
REFERENCES [dbo].[DanhMuc] ([Id])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IdNSX])
REFERENCES [dbo].[NSX] ([Id])
GO
USE [master]
GO
ALTER DATABASE [PRO1041_G7_V8] SET  READ_WRITE 
GO