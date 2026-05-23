import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame {

    // Colors
    private static final Color BG_DARK     = new Color(13, 17, 30);
    private static final Color BG_CARD     = new Color(22, 28, 48);
    private static final Color ACCENT_GOLD = new Color(212, 175, 100);
    private static final Color ACCENT_BLUE = new Color(80, 140, 220);
    private static final Color TEXT_WHITE  = new Color(230, 230, 240);
    private static final Color TEXT_MUTED  = new Color(130, 140, 165);
    private static final Color BORDER_COL  = new Color(40, 52, 80);

    public MainScreen() {
        setTitle("Library 2.0 — Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 640);
        setMinimumSize(new Dimension(800, 520));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_DARK);

        add(buildSidebar(), BorderLayout.WEST);
        add(buildMainPanel(), BorderLayout.CENTER);
    }

    // ── SIDEBAR ────────────────────────────────────────
    private JPanel buildSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(BG_CARD);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDER_COL));

        // Logo
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        logoPanel.setBackground(BG_CARD);
        logoPanel.setMaximumSize(new Dimension(220, 90));
        logoPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COL));

        JLabel iconLbl = new JLabel("📚", SwingConstants.CENTER);
        iconLbl.setFont(new Font("Serif", Font.PLAIN, 28));
        iconLbl.setForeground(ACCENT_GOLD);
        iconLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLbl = new JLabel("Library 2.0", SwingConstants.CENTER);
        titleLbl.setFont(new Font("Georgia", Font.BOLD, 15));
        titleLbl.setForeground(ACCENT_GOLD);
        titleLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        logoPanel.add(Box.createVerticalStrut(14));
        logoPanel.add(iconLbl);
        logoPanel.add(Box.createVerticalStrut(4));
        logoPanel.add(titleLbl);
        logoPanel.add(Box.createVerticalStrut(14));
        sidebar.add(logoPanel);
        sidebar.add(Box.createVerticalStrut(16));

        // Section label
        sidebar.add(makeSectionLabel("NAVIGATION"));

        // Nav items
        String[][] nav = {
            {"🏠", "Dashboard",  "Overview & stats"},
            {"📖", "Catalog",    "Books & materials"},
            {"👤", "Users",      "Manage members"},
            {"🔄", "Loans",      "Borrow & return"},
            {"🔍", "Search",     "Find anything"},
        };
        for (String[] item : nav) {
            sidebar.add(makeNavButton(item[0], item[1], item[2]));
            sidebar.add(Box.createVerticalStrut(4));
        }

        sidebar.add(Box.createVerticalGlue());

        // Version
        JLabel version = new JLabel("v1.0  —  POO Project", SwingConstants.CENTER);
        version.setFont(new Font("SansSerif", Font.PLAIN, 10));
        version.setForeground(TEXT_MUTED);
        version.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(version);
        sidebar.add(Box.createVerticalStrut(12));

        return sidebar;
    }

    private JLabel makeSectionLabel(String text) {
        JLabel lbl = new JLabel("  " + text);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 10));
        lbl.setForeground(TEXT_MUTED);
        lbl.setMaximumSize(new Dimension(220, 24));
        return lbl;
    }

    private JPanel makeNavButton(String icon, String label, String subtitle) {
        JPanel btn = new JPanel(new BorderLayout(10, 0));
        btn.setBackground(BG_CARD);
        btn.setMaximumSize(new Dimension(220, 56));
        btn.setBorder(BorderFactory.createEmptyBorder(6, 14, 6, 14));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel iconLbl = new JLabel(icon);
        iconLbl.setFont(new Font("SansSerif", Font.PLAIN, 18));

        JPanel texts = new JPanel();
        texts.setLayout(new BoxLayout(texts, BoxLayout.Y_AXIS));
        texts.setBackground(BG_CARD);

        JLabel nameLbl = new JLabel(label);
        nameLbl.setFont(new Font("SansSerif", Font.BOLD, 13));
        nameLbl.setForeground(TEXT_WHITE);

        JLabel subLbl = new JLabel(subtitle);
        subLbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
        subLbl.setForeground(TEXT_MUTED);

        texts.add(nameLbl);
        texts.add(subLbl);
        btn.add(iconLbl, BorderLayout.WEST);
        btn.add(texts, BorderLayout.CENTER);

        // Hover effect
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(35, 45, 72));
                texts.setBackground(new Color(35, 45, 72));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(BG_CARD);
                texts.setBackground(BG_CARD);
            }
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,
                    label + " screen coming soon!", label, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return btn;
    }

    // ── MAIN PANEL ─────────────────────────────────────
    private JPanel buildMainPanel() {
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BG_DARK);

        // Top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(BG_CARD);
        topBar.setPreferredSize(new Dimension(0, 60));
        topBar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COL),
            BorderFactory.createEmptyBorder(0, 20, 0, 20)
        ));

        JLabel pageTitle = new JLabel("Dashboard");
        pageTitle.setFont(new Font("Georgia", Font.BOLD, 18));
        pageTitle.setForeground(TEXT_WHITE);

        JLabel dateLabel = new JLabel("Library Management System");
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        dateLabel.setForeground(TEXT_MUTED);

        topBar.add(pageTitle, BorderLayout.WEST);
        topBar.add(dateLabel, BorderLayout.EAST);
        main.add(topBar, BorderLayout.NORTH);

        // Cards grid
        JPanel grid = new JPanel(new GridLayout(2, 3, 16, 16));
        grid.setBackground(BG_DARK);
        grid.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        String[][] cards = {
            {"📖", "Catalog",       "Add and list books\nand materials"},
            {"👤", "Users",         "Register students\nand teachers"},
            {"🔄", "Loans",         "Borrow and return\nmaterials"},
            {"🔍", "Search",        "Find by title\nor code"},
            {"📋", "Active Loans",  "See all current\nborrowed items"},
            {"⚙️",  "Settings",     "Configure library\nparameters"},
        };

        for (String[] card : cards) {
            grid.add(makeCard(card[0], card[1], card[2]));
        }

        main.add(grid, BorderLayout.CENTER);

        // Bottom status bar
        JPanel status = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 8));
        status.setBackground(BG_CARD);
        status.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, BORDER_COL));

        JLabel dot = new JLabel("●");
        dot.setForeground(new Color(80, 200, 120));
        dot.setFont(new Font("SansSerif", Font.PLAIN, 10));

        JLabel statusLbl = new JLabel("System ready — Library 2.0");
        statusLbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
        statusLbl.setForeground(TEXT_MUTED);

        status.add(dot);
        status.add(statusLbl);
        main.add(status, BorderLayout.SOUTH);

        return main;
    }

    private JPanel makeCard(String icon, String title, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COL, 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel iconLbl = new JLabel(icon);
        iconLbl.setFont(new Font("SansSerif", Font.PLAIN, 32));
        iconLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(new Font("Georgia", Font.BOLD, 15));
        titleLbl.setForeground(TEXT_WHITE);
        titleLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (String line : description.split("\n")) {
            JLabel descLbl = new JLabel(line);
            descLbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
            descLbl.setForeground(TEXT_MUTED);
            descLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(descLbl);
        }

        card.add(iconLbl);
        card.add(Box.createVerticalStrut(10));
        card.add(titleLbl);
        card.add(Box.createVerticalStrut(6));

        // Re-add description labels (fix order)
        card.removeAll();
        card.add(iconLbl);
        card.add(Box.createVerticalStrut(10));
        card.add(titleLbl);
        card.add(Box.createVerticalStrut(6));
        for (String line : description.split("\n")) {
            JLabel descLbl = new JLabel(line);
            descLbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
            descLbl.setForeground(TEXT_MUTED);
            descLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(descLbl);
        }

        // Hover
        card.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(30, 38, 64));
                card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(ACCENT_BLUE, 1),
                    BorderFactory.createEmptyBorder(20, 20, 20, 20)
                ));
            }
            public void mouseExited(MouseEvent e) {
                card.setBackground(BG_CARD);
                card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_COL, 1),
                    BorderFactory.createEmptyBorder(20, 20, 20, 20)
                ));
            }
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,
                    title + " screen coming soon!", title, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return card;
    }

    // ── ENTRY POINT ────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new MainScreen().setVisible(true);
        });
    }
}