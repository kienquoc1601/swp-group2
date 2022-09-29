USE [master]
GO
/****** Object:  Database [OnLearningDB]    Script Date: 9/29/2022 10:33:19 PM ******/
CREATE DATABASE [OnLearningDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnLearningDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\OnLearningDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'OnLearningDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\OnLearningDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [OnLearningDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnLearningDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnLearningDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnLearningDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnLearningDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnLearningDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnLearningDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnLearningDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnLearningDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnLearningDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnLearningDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnLearningDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnLearningDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnLearningDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnLearningDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnLearningDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnLearningDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [OnLearningDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnLearningDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnLearningDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnLearningDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnLearningDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnLearningDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnLearningDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnLearningDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [OnLearningDB] SET  MULTI_USER 
GO
ALTER DATABASE [OnLearningDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnLearningDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnLearningDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnLearningDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [OnLearningDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [OnLearningDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnLearningDB', N'ON'
GO
ALTER DATABASE [OnLearningDB] SET QUERY_STORE = OFF
GO
USE [OnLearningDB]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Account_1] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[adminID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[adminID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Answer]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answer](
	[answerID] [int] IDENTITY(1,1) NOT NULL,
	[questionID] [int] NOT NULL,
	[mentorID] [int] NOT NULL,
	[answer] [varchar](max) NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_Answer] PRIMARY KEY CLUSTERED 
(
	[answerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Assessment]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Assessment](
	[assessmentID] [int] IDENTITY(1,1) NOT NULL,
	[moduleID] [int] NOT NULL,
	[studentID] [int] NOT NULL,
	[mentorID] [int] NULL,
	[grade] [float] NULL,
	[review] [varchar](max) NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_Assessment] PRIMARY KEY CLUSTERED 
(
	[assessmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Blog]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Blog](
	[blog_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[blog_image] [nvarchar](255) NULL,
	[blog_description] [nvarchar](1000) NULL,
	[poster_uname] [varchar](50) NULL,
	[blog_content] [nvarchar](max) NULL,
	[category] [nvarchar](255) NULL,
	[rating] [float] NOT NULL,
	[date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[blog_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[categoryID] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Certificate](
	[certID] [int] IDENTITY(1,1) NOT NULL,
	[courseID] [int] NOT NULL,
	[cert_name] [varchar](50) NOT NULL,
	[cert_detail] [varchar](max) NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_Certificate] PRIMARY KEY CLUSTERED 
(
	[certID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Chapter]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chapter](
	[chapterID] [int] IDENTITY(1,1) NOT NULL,
	[courseID] [int] NOT NULL,
	[chapter_name] [varchar](50) NOT NULL,
	[chapter_num] [int] NOT NULL,
	[chapter_description] [varchar](50) NULL,
 CONSTRAINT [PK_Chapter] PRIMARY KEY CLUSTERED 
(
	[chapterID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[commentID] [int] IDENTITY(1,1) NOT NULL,
	[blogID] [int] NOT NULL,
	[commenterUname] [varchar](50) NOT NULL,
	[comment_content] [nvarchar](max) NULL,
	[date] [date] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[courseID] [int] IDENTITY(1,1) NOT NULL,
	[course_name] [varchar](50) NOT NULL,
	[course_manager] [int] NULL,
	[description] [varchar](max) NULL,
	[img_src] [varchar](50) NULL,
	[rating] [float] NULL,
 CONSTRAINT [PK_Course] PRIMARY KEY CLUSTERED 
(
	[courseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CourseCategory]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CourseCategory](
	[categoryID] [int] NOT NULL,
	[courseID] [int] NOT NULL,
 CONSTRAINT [PK_CourseCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC,
	[courseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CourseMentor]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CourseMentor](
	[courseID] [int] NOT NULL,
	[mentorID] [int] NOT NULL,
 CONSTRAINT [PK_CourseMentor] PRIMARY KEY CLUSTERED 
(
	[courseID] ASC,
	[mentorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CourseStudent]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CourseStudent](
	[studentID] [int] NOT NULL,
	[courseID] [int] NOT NULL,
 CONSTRAINT [PK_CourseStudent] PRIMARY KEY CLUSTERED 
(
	[studentID] ASC,
	[courseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feature]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feature](
	[featureID] [int] IDENTITY(1,1) NOT NULL,
	[feature_name] [varchar](50) NOT NULL,
	[url] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Feature] PRIMARY KEY CLUSTERED 
(
	[featureID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[managerID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[org_name] [varchar](50) NOT NULL,
	[img_src] [varchar](50) NULL,
	[rating] [float] NULL,
 CONSTRAINT [PK_Manager] PRIMARY KEY CLUSTERED 
(
	[managerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mentor]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mentor](
	[mentorID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[fullname] [varchar](50) NULL,
	[img_src] [varchar](50) NULL,
	[gender] [bit] NULL,
	[dob] [date] NOT NULL,
 CONSTRAINT [PK_Mentor] PRIMARY KEY CLUSTERED 
(
	[mentorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Module]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Module](
	[moduleID] [int] IDENTITY(1,1) NOT NULL,
	[chapterID] [int] NOT NULL,
	[module_name] [nchar](10) NULL,
	[module_num] [int] NULL,
	[module_type] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Module] PRIMARY KEY CLUSTERED 
(
	[moduleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[questionID] [int] IDENTITY(1,1) NOT NULL,
	[studentID] [int] NOT NULL,
	[courseID] [int] NOT NULL,
	[is_solved] [bit] NOT NULL,
	[q_content] [varchar](max) NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[questionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Review]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[reviewID] [int] IDENTITY(1,1) NOT NULL,
	[studentID] [int] NOT NULL,
	[courseID] [int] NOT NULL,
	[review_name] [varchar](50) NULL,
	[review_detail] [varchar](max) NULL,
	[rating] [float] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED 
(
	[reviewID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[roleID] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleAccount]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleAccount](
	[roleID] [int] NOT NULL,
	[username] [varchar](50) NOT NULL,
 CONSTRAINT [PK_RoleAccount] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC,
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleFeature]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleFeature](
	[roleID] [int] NOT NULL,
	[featureID] [int] NOT NULL,
 CONSTRAINT [PK_RoleFeature] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC,
	[featureID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[studentID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[fullname] [varchar](50) NULL,
	[img_src] [varchar](50) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[studentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StudentCertificate]    Script Date: 9/29/2022 10:33:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StudentCertificate](
	[studentID] [int] NOT NULL,
	[certID] [int] NOT NULL,
 CONSTRAINT [PK_StudentCertificate] PRIMARY KEY CLUSTERED 
(
	[studentID] ASC,
	[certID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'Minh HD', N'123')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'oaipbhe150516', N'123')
GO
SET IDENTITY_INSERT [dbo].[Blog] ON 

INSERT [dbo].[Blog] ([blog_id], [title], [blog_image], [blog_description], [poster_uname], [blog_content], [category], [rating], [date]) VALUES (1, N'title', N'image', N'décription', N'oaipbhe150516', N'content', N'Phim', 2.5, CAST(N'2022-12-02' AS Date))
INSERT [dbo].[Blog] ([blog_id], [title], [blog_image], [blog_description], [poster_uname], [blog_content], [category], [rating], [date]) VALUES (2, N'Không xem Cyberpunk Edgerunner thì phí ', N'https://images.spiderum.com/sp-images/208c4cd03ae911edba5db9e047c4f56d.jpeg', N'Trái với mục tiêu ban đầu, Cyberpunk Edgerunner đã hoàn thành xuất sắc hơn cả kỳ vọng là một con cờ để quảng bá cho tựa Game. Nó đã trở thành một bộ phim mà theo tôi, nếu không xem thì phí cả đời.', N'Minh HD', N'Cyberpunk 2077\n ban đầu được hứa hẹn là một tựa Game bom tấn tới từ nhà phát hành Ba Lan CD Projekt Red. Với sự thành công ngoài sức tưởng tượng của siêu phẩm The Witcher 3: Wild Hunt trước đó, không quá lạ khi cả thế giới đặt kỳ vọng rất cao vào tựa Game Cyberpunk 2077. CDR hiểu rõ điều đó, nên họ đã có hẳn một kế hoạch dài hơi dành cho dự án thuộc vũ trụ Cyberpunk, trong đó có bao gồm một Series Anime riêng. Nhưng mọi thứ không như dự tính, Cyberpunk 2077 trở thành một thất bại thảm hại bởi vô số các lỗi kỹ thuật mà người chơi gặp phải. Cú ngã ngựa này nặng tới mức khiến giá trị vốn hóa của công ty chủ quản rớt thẳng xuống lòng đất, giảm tới 75% so với giá trị ban đầu. Dự án Anime của Cyberpunk 2077 cũng theo đó mà rơi vào quên lãng. 2 năm sau, CD Projekt Red chấp nhận hy sinh danh tiếng của mình để làm mọi cách để cứu vớt đứa con tinh thần. Bên cạnh các bản cập nhật sửa lỗi liên tục, công bố các nội dung DLC mở rộng cho tựa Game gốc, bộ Anime Cyberpunk Edgerunner được phát hành trên Netflix cũng là một nỗ lực nhằm lôi kéo người chơi mới và đưa người chơi cũ trở lại với Night City. Trái với mục tiêu ban đầu, Cyberpunk Edgerunner đã hoàn thành xuất sắc hơn cả kỳ vọng là một con cờ để quảng bá cho tựa Game. Nó đã trở thành một bộ phim mà theo tôi, nếu không xem thì phí cả đời. 
Có thể bài viết này sẽ không thể lồng các cảnh phim để mô tả một cách chi tiết và rõ ràng nhất, bởi chúng tôi sợ bị Youtube gõ gậy. Nên tôi rất khuyến khích các bạn hãy dành thời gian khoảng 3 tiếng buổi tối để làm một tour dạo quanh thành phố Night City đẹp đẽ nhưng đầy chết chóc. Và đây cũng là cảnh báo Spoiler tới các bạn. Dù đây là một bộ phim dựa theo tựa Game Cyberpunk 2077, nhưng các bạn sẽ không cần phải chơi hết trò chơi để có thể theo dõi được câu chuyện mà bộ phim muốn truyền tải. Cyberpunk Edgerunner diễn ra trong một thế giới giả tưởng, lấy bối cảnh chủ yếu tại thành phố Night City. Nhân vật chính của chúng ta là David, một cậu nhóc thuộc tầng lớp thấp của xã hội. Để con trai mình có được một cuộc sống đỡ vất vả hơn, mẹ của cậu đã phải vật lộn mưu sinh để chu cấp cho con trai mình học tại học viện Arasaka, học viện lớn nhất Night City, với kỳ vọng một ngày nào đó, David có thể được làm việc tại tập đoàn lớn nhất nhì nơi đây. Nhưng một tai nạn đã bất ngờ xảy ra khiến mẹ cậu qua đời. Không chấp nhận số phận, David quyết định cấy vào cơ thể một khung xương Sandevistan, vũ khí tối tân thuộc cấp quân đội, có khả năng đưa người sử dụng vào trạng thái bullet time. Đây là một loại bộ phận mà không phải ai cũng có khả năng sử dụng với tần suất cao, nhưng David Martinez thì khác. Anh có thể sử dụng nó liên tục 8-10 lần trong một ngày mà vẫn giữ lại được lí trí, trong khi giới hạn bình thường chỉ là 2 lần mỗi ngày. David sau đó sử dụng Sandevistan để tiến vào con đường phạm pháp nhằm sinh tồn với sự khắc nghiệt mà Night City đem lại. Trong khoảnh khắc đen tối nhất của cuộc đời, David đã gặp Lucy, một Hacker thiên tài, và những con người thuộc băng đảng của cô ấy. Tham gia vào nhóm, David bắt đầu hành trình của mình để tìm được mục đích của bản thân, để sống sót, và để lật đổ những bất công của xã hội này. Các sự kiện trong  Cyberpunk Edgerunner xảy ra trước tất cả các sự kiện chính trong cốt truyện của Cyberpunk 2077. Có thể xác nhận rõ ràng nhất khi trùm cuối Adam Smasher vẫn còn sống trong bộ Anime. Nhưng việc chưa từng chơi qua tựa Game chính không phải là trở ngại để ngăn bạn có được trải nghiệm trọn vẹn nhất với bộ phim. Thế giới của Cyberpunk 2077 được thiết kế tương đối tỉ mỉ và phong phú, có thể là nền tảng để xây dựng được những câu chuyện có chiều sâu. Câu chuyện được kể trong bản Game chính theo cá nhân tôi là chưa đủ thấm, nhưng Edgerunner lại hoàn toàn khác. Ý tưởng về một nhân vật ở dưới đáy xã hội trong bối cảnh Cyberpunk tìm cách để có được vị thế của mình không phải là một điều mới lạ. Nhưng cách mà Cyberpunk Edgerunner thể hiện ý tưởng đó khiến nó trở nên khác biệt. Các biên kịch xây dựng và phát triển các nhân vật của mình một cách hoàn hảo tạo được sự hứng thú đối với khán giả, khiến họ tò mò muốn đi cùng các nhân vật tới cuối cuộc hành trình. David là kiểu mẫu nhân vật chính tương đối dễ tạo thiện cảm, có tính cách đàng hoàng và có một sự phát triển rõ ràng. Để có được sự phát triển thuyết phục ấy phải là sự tổng hòa của 2 yếu tố, đó là các nhân vật đồng hành và các sự kiện xảy ra trong toàn bộ thời lượng của phim. 
Tôi cũng được nghe khá nhiều ý kiến của cộng đồng, cho rằng bộ phim đẩy tình tiết quá nhanh khiến cho các nhân vật không được miêu tả tâm lý đầy đủ. Dẫn đến tình trạng nhân vật không tạo được dấu ấn đậm nét. Nhưng tôi không nghĩ như vậy. Không như các bộ Anime thông thường, ở giữa mỗi một sự kiện quan trọng thì chúng ta thường có các quãng nghỉ để mô tả kỹ càng hơn tâm lý và tương tác của các nhân vật với nhau. Nhưng đối với Edgerunner, các tình tiết cứ liên tục nối tiếp mà không có các quãng nghỉ cần thiết. Nếu bạn cày liên tục 10 tập một lúc thì cảm giác phim bị rush là một điều không thể tránh khỏi. Ở giữa mỗi tập phim, tôi thường dành ra 5-10’ nghỉ giữa chừng để ngẫm nghĩ lại các sự kiện vừa xảy ra, những sự kiện đó tác động như thế nào tới tâm lý của nhân vật, và thông qua các tình tiết đó thì nhà làm phim đang muốn truyền tải với tôi thông điệp gì. 
Lấy ví dụ ở ngay tập đầu tiên, một loạt các sự kiện không may xảy ra đối với nhân vật chính David. Tất cả các rắc rối của cậu đều xuất phát vì chuyện kinh tế tiền bạc, dần xây dựng hình ảnh của một Night City tàn bạo, nếu sống trong đó mà không có tiền, không có quyền, không có sức mạnh, bạn sẽ bị thành phố ấy ăn sống một cách dã man nhất. Để rồi sau đó David đã phải mạo hiểm cấy món vũ khí chết chóc vào cơ thể chỉ để có sức mạnh sinh tồn. Nhưng xong rồi trên cuộc hành trình của mình, David đã dần tìm được ý nghĩa thực sự của cuộc sống thông qua những người cùng đồng hành với cậu. Đó là cô nàng Lucy xinh đẹp, là nhóc Rebecca nhí nhố, hay là nhân vật hình mẫu người anh đáng tin cậy Maine chẳng hạn. Tất cả đều được xây dựng để giải thích lựa chọn của David đưa ra vào cuối phim dẫn tới cái kết vừa ngọt vừa đắng của Cyberpunk Edgerunner.   Nói thêm một chút về cách mà bộ phim xây dựng mối quan hệ của David và Lucy. Theo tôi, đây là cặp đôi dễ liên hệ với thực tế nhất trong các Anime ra mắt gần đây. Cả hai dù không trao cho nhau những lời thân mật với tần suất dày đặc, nhưng họ đều làm tất cả mọi thứ vì người kia. Ngay cả chuyện từ bỏ mối quan hệ của chính mình vì sự an nguy của người mà họ yêu quý, nhưng đằng sau, họ đều đặt mạng sống của mình vào sự nguy hiểm để mang về an toàn cho người còn lại. Đối với Lucy, với vai trò là một Netrunner thì cô làm mọi cách để đưa David ra ngoài tầm ngắm của tập đoàn Arasaka. Còn đối với David, cậu ta bất chấp rủi ro có thể mất đi nhân tính của mình để liên tục cấy vào cơ thể các thiết bị công nghệ cao, có được sức mạnh và mang về an toàn cho Lucy. 
Lucy và Rebecca có lẽ sẽ là waifu của rất nhiều người. Nhưng đối với tôi, Maine mới là nhân vật để lại ấn tượng sâu sắc nhất. Khai thác một khái niệm cơ bản của trò chơi Cyberpunk 2077, Cyber-psycho, tạm dịch là “siêu cuồng nhân”, Edgerunner đưa yếu tố này lên hẳn một tầm cao mới khi đi sâu hơn vào phần con người của những kẻ đang dần mất đi nhận thức để có được sức mạnh. Và Maine là nhân vật được mang ra để truyền tải thông điệp này. Tôi biết đây không phải thông điệp mới mẻ vì cũng có khá nhiều sản phẩm lấy chủ đề Cyberpunk này đã khai thác từ trước. Tập thứ 6 của Edgerunner thể hiện ý tưởng về một kẻ cố gắng lấy lại tâm trí khi phần máy trong cơ thể còn nhiều hơn cả phần thịt một cách vô cùng mới lạ thông qua cả câu chuyện, hình ảnh lẫn âm thanh. Tôi sẽ phân tích kỹ hơn ở đoạn sau của bài viết.  Cyber-psycho không phải là yếu tố duy nhất được khai thác từ Game để đưa vào trong bộ phim. Có thể nói, tôi chưa bao giờ được xem một bộ phim nào bám sát với nguyên tác tới vậy.
Thậm chí, các nhà làm phim còn nhận thức được quãng thời gian ra mắt thảm họa của Cyberpunk 2077, đầy rẫy bug. Nên cài cắm trong phim cũng là vô số những cái nháy mắt của nhà làm phim tới những ai đã từng trải nghiệm tựa Game vào năm 2020. Và phải đến 99% tất cả những gì được thể hiện ở trên phim, bạn cũng có thể tìm thấy được nó ở trong Game. Tôi sẽ tận dụng quãng thời gian hơn 80 giờ chơi Cyberpunk 2077 để liệt kê cho các bạn một số các yếu tố trong game có xuất hiện trên phim. 
- Khái niệm BrainDance, các nhân vật trong phim hay gọi là BD, giúp người dùng có thể chìm đắm và trải nghiệm một sự việc nào đó bằng hầu hết tất cả các giác quan.  
- Khái niệm Deep Dive Hacking, yêu cầu hacker phải ngâm mình vào một bể nước lạnh. 
- Đội Trauma Team, có thể hiểu là một đội cứu hộ khẩn cấp phục vụ độc quyền cho một khách hàng nào đó, mà như đã thấy ở trên Anime, đội này bỏ qua mẹ của David trong vụ tai nạn mà chỉ tập trung cứu khách hàng của mình. 
- Hãng Taxi A.I có tên Delamain cũng có mặt trong bộ phim. 
- Các nhóm băng đảng bao gồm nhóm Tyger Claws, Maelstrom, Animals of Pacifica cũng có những phân cảnh chiến đấu của riêng mình. Dù trong hầu hết thời lượng, chúng chỉ là bao cát để David cùng nhóm của mình bón hành. 
- Một số các nhân vật NPC quan trọng của Game Cyberpunk 2077 cũng có màn Cameo cho mình ở trong Edgerunner, trong đó có Rogue, Claire và Wakako. 
- Hầu hết các địa điểm ở trong phim cũng được tìm thấy bên trong tựa Game. Nổi bật trong đó có thể liệt kê một vài địa điểm quan trọng như quán ăn Tom’s Diner, nhà của các nhân vật bao gồm Lucy, David, Rebecca, Kiwi; cửa hàng Ripper’s Doc chuyên cấy ghép thiết bị cho David, quán Turbo’s Bar, và quán Bar Afterlife. Quan trọng nhất, ở quán Afterlife trong Game có rất nhiều loại đồ uống được đặt theo tên của các nhân vật đã qua đời có tầm ảnh hưởng lớn tới thế giới ngầm của Night City. Trong đó có 2 loại đồ uống nổi bật. Đó là Johnny Silverhand, nhân vật do Keanu Reeves thủ vai trong Game. Và còn lại là David Martinez. Món đồ uống này đã xuất hiện trong quán Bar Afterlife kể từ khi Cyberpunk 2077 ra mắt năm 2020. Phải tới tận bây giờ, chúng ta mới biết được David Martinez thực sự là ai. ', N'Phim', 2, CAST(N'2022-09-24' AS Date))
SET IDENTITY_INSERT [dbo].[Blog] OFF
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FK_Admin_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FK_Admin_Account]
GO
ALTER TABLE [dbo].[Answer]  WITH CHECK ADD  CONSTRAINT [FK_Answer_Mentor] FOREIGN KEY([mentorID])
REFERENCES [dbo].[Mentor] ([mentorID])
GO
ALTER TABLE [dbo].[Answer] CHECK CONSTRAINT [FK_Answer_Mentor]
GO
ALTER TABLE [dbo].[Answer]  WITH CHECK ADD  CONSTRAINT [FK_Answer_Question] FOREIGN KEY([questionID])
REFERENCES [dbo].[Question] ([questionID])
GO
ALTER TABLE [dbo].[Answer] CHECK CONSTRAINT [FK_Answer_Question]
GO
ALTER TABLE [dbo].[Assessment]  WITH CHECK ADD  CONSTRAINT [FK_Assessment_Mentor] FOREIGN KEY([mentorID])
REFERENCES [dbo].[Mentor] ([mentorID])
GO
ALTER TABLE [dbo].[Assessment] CHECK CONSTRAINT [FK_Assessment_Mentor]
GO
ALTER TABLE [dbo].[Assessment]  WITH CHECK ADD  CONSTRAINT [FK_Assessment_Module] FOREIGN KEY([moduleID])
REFERENCES [dbo].[Module] ([moduleID])
GO
ALTER TABLE [dbo].[Assessment] CHECK CONSTRAINT [FK_Assessment_Module]
GO
ALTER TABLE [dbo].[Assessment]  WITH CHECK ADD  CONSTRAINT [FK_Assessment_Student] FOREIGN KEY([studentID])
REFERENCES [dbo].[Student] ([studentID])
GO
ALTER TABLE [dbo].[Assessment] CHECK CONSTRAINT [FK_Assessment_Student]
GO
ALTER TABLE [dbo].[Blog]  WITH CHECK ADD  CONSTRAINT [FK_Blog_Account] FOREIGN KEY([poster_uname])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Blog] CHECK CONSTRAINT [FK_Blog_Account]
GO
ALTER TABLE [dbo].[Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Certificate_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[Certificate] CHECK CONSTRAINT [FK_Certificate_Course]
GO
ALTER TABLE [dbo].[Chapter]  WITH CHECK ADD  CONSTRAINT [FK_Chapter_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[Chapter] CHECK CONSTRAINT [FK_Chapter_Course]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Account] FOREIGN KEY([commenterUname])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Account]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Blog] FOREIGN KEY([blogID])
REFERENCES [dbo].[Blog] ([blog_id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Blog]
GO
ALTER TABLE [dbo].[Course]  WITH CHECK ADD  CONSTRAINT [FK_Course_Manager] FOREIGN KEY([course_manager])
REFERENCES [dbo].[Manager] ([managerID])
GO
ALTER TABLE [dbo].[Course] CHECK CONSTRAINT [FK_Course_Manager]
GO
ALTER TABLE [dbo].[Course]  WITH CHECK ADD  CONSTRAINT [FKsl1f5y8cmoiu4aa0ycj82mlsn] FOREIGN KEY([course_manager])
REFERENCES [dbo].[Manager] ([managerID])
GO
ALTER TABLE [dbo].[Course] CHECK CONSTRAINT [FKsl1f5y8cmoiu4aa0ycj82mlsn]
GO
ALTER TABLE [dbo].[CourseCategory]  WITH CHECK ADD  CONSTRAINT [FK_CourseCategory_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[CourseCategory] CHECK CONSTRAINT [FK_CourseCategory_Category]
GO
ALTER TABLE [dbo].[CourseCategory]  WITH CHECK ADD  CONSTRAINT [FK_CourseCategory_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[CourseCategory] CHECK CONSTRAINT [FK_CourseCategory_Course]
GO
ALTER TABLE [dbo].[CourseMentor]  WITH CHECK ADD  CONSTRAINT [FK_CourseMentor_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[CourseMentor] CHECK CONSTRAINT [FK_CourseMentor_Course]
GO
ALTER TABLE [dbo].[CourseMentor]  WITH CHECK ADD  CONSTRAINT [FK_CourseMentor_Mentor] FOREIGN KEY([mentorID])
REFERENCES [dbo].[Mentor] ([mentorID])
GO
ALTER TABLE [dbo].[CourseMentor] CHECK CONSTRAINT [FK_CourseMentor_Mentor]
GO
ALTER TABLE [dbo].[CourseStudent]  WITH CHECK ADD  CONSTRAINT [FK_CourseStudent_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[CourseStudent] CHECK CONSTRAINT [FK_CourseStudent_Course]
GO
ALTER TABLE [dbo].[CourseStudent]  WITH CHECK ADD  CONSTRAINT [FK_CourseStudent_Student] FOREIGN KEY([studentID])
REFERENCES [dbo].[Student] ([studentID])
GO
ALTER TABLE [dbo].[CourseStudent] CHECK CONSTRAINT [FK_CourseStudent_Student]
GO
ALTER TABLE [dbo].[Manager]  WITH CHECK ADD  CONSTRAINT [FK_Manager_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Manager] CHECK CONSTRAINT [FK_Manager_Account]
GO
ALTER TABLE [dbo].[Mentor]  WITH CHECK ADD  CONSTRAINT [FK_Mentor_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Mentor] CHECK CONSTRAINT [FK_Mentor_Account]
GO
ALTER TABLE [dbo].[Module]  WITH CHECK ADD  CONSTRAINT [FK_Module_Chapter] FOREIGN KEY([chapterID])
REFERENCES [dbo].[Chapter] ([chapterID])
GO
ALTER TABLE [dbo].[Module] CHECK CONSTRAINT [FK_Module_Chapter]
GO
ALTER TABLE [dbo].[Question]  WITH CHECK ADD  CONSTRAINT [FK_Question_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[Question] CHECK CONSTRAINT [FK_Question_Course]
GO
ALTER TABLE [dbo].[Question]  WITH CHECK ADD  CONSTRAINT [FK_Question_Student] FOREIGN KEY([studentID])
REFERENCES [dbo].[Student] ([studentID])
GO
ALTER TABLE [dbo].[Question] CHECK CONSTRAINT [FK_Question_Student]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Course] FOREIGN KEY([courseID])
REFERENCES [dbo].[Course] ([courseID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Course]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Student] FOREIGN KEY([studentID])
REFERENCES [dbo].[Student] ([studentID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Student]
GO
ALTER TABLE [dbo].[RoleAccount]  WITH CHECK ADD  CONSTRAINT [FK_RoleAccount_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[RoleAccount] CHECK CONSTRAINT [FK_RoleAccount_Account]
GO
ALTER TABLE [dbo].[RoleAccount]  WITH CHECK ADD  CONSTRAINT [FK_RoleAccount_Role] FOREIGN KEY([roleID])
REFERENCES [dbo].[Role] ([roleID])
GO
ALTER TABLE [dbo].[RoleAccount] CHECK CONSTRAINT [FK_RoleAccount_Role]
GO
ALTER TABLE [dbo].[RoleFeature]  WITH CHECK ADD  CONSTRAINT [FK_RoleFeature_Feature] FOREIGN KEY([featureID])
REFERENCES [dbo].[Feature] ([featureID])
GO
ALTER TABLE [dbo].[RoleFeature] CHECK CONSTRAINT [FK_RoleFeature_Feature]
GO
ALTER TABLE [dbo].[RoleFeature]  WITH CHECK ADD  CONSTRAINT [FK_RoleFeature_Role] FOREIGN KEY([roleID])
REFERENCES [dbo].[Role] ([roleID])
GO
ALTER TABLE [dbo].[RoleFeature] CHECK CONSTRAINT [FK_RoleFeature_Role]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Account] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Account]
GO
ALTER TABLE [dbo].[StudentCertificate]  WITH CHECK ADD  CONSTRAINT [FK_StudentCertificate_Certificate] FOREIGN KEY([certID])
REFERENCES [dbo].[Certificate] ([certID])
GO
ALTER TABLE [dbo].[StudentCertificate] CHECK CONSTRAINT [FK_StudentCertificate_Certificate]
GO
ALTER TABLE [dbo].[StudentCertificate]  WITH CHECK ADD  CONSTRAINT [FK_StudentCertificate_Student] FOREIGN KEY([studentID])
REFERENCES [dbo].[Student] ([studentID])
GO
ALTER TABLE [dbo].[StudentCertificate] CHECK CONSTRAINT [FK_StudentCertificate_Student]
GO
USE [master]
GO
ALTER DATABASE [OnLearningDB] SET  READ_WRITE 
GO
